<%@page import="com.sayantan.ActionForm.Gui2FormVars"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible"
          content="IE=EmulateIE7; IE=EmulateIE9">
    <!--[if IE]><script src="path/to/excanvas.js"></script><![endif]-->
    <script type="text/javascript" src="demo_files/dygraph-dev.js"></script>
    <script type="text/javascript" src="demo_files/strftime-min.js"></script>
    <script type="text/javascript" src="demo_files/rgbcolor.js"></script>
    <script type="text/javascript" src="demo_files/stacktrace.js"></script>
    <script type="text/javascript" src="demo_files/dashed-canvas.js"></script>
    <script type="text/javascript" src="demo_files/dygraph-layout.js"></script>
    <script type="text/javascript" src="demo_files/dygraph-canvas.js"></script>
    <script type="text/javascript" src="demo_files/dygraph.js"></script>
    <script type="text/javascript" src="demo_files/dygraph-utils.js"></script>
    <script type="text/javascript" src="demo_files/dygraph-gviz.js"></script>
    <script type="text/javascript"
            src="demo_files/dygraph-interaction-model.js"></script>
    <script type="text/javascript"
            src="demo_files/dygraph-range-selector.js"></script>
    <script type="text/javascript" src="demo_files/dygraph-tickers.js"></script>
    <script type="text/javascript" src="demo_files/base.js"></script>
    <script type="text/javascript" src="demo_files/annotations.js"></script>
    <script type="text/javascript" src="demo_files/axes.js"></script>
    <script type="text/javascript" src="demo_files/chart-labels.js"></script>
    <script type="text/javascript" src="demo_files/grid.js"></script>
    <script type="text/javascript" src="demo_files/legend.js"></script>
    <script type="text/javascript" src="demo_files/install.js"></script>
    <script type="text/javascript"
            src="demo_files/dygraph-options-reference.js"></script>
    <script type="text/javascript" src="demo_files/dygraph-combined.js"></script>
    <link type="text/css" rel="stylesheet"
          href="datepicker/datepickercontrol.css">
    <link rel="stylesheet" type="text/css" href="css/global.css" />
    <link type="text/css" rel="stylesheet" href="css/displayDecorator.css">
    <link type="text/css" rel="stylesheet" href="css/base.css">
    <link type="text/css" rel="stylesheet" href="css/screen.css">
    <link type="text/css" rel="stylesheet" href="css/global.css">
    <title>Access Data Details</title>
</head>
<body>
<!-- Input form -->
<s:form name="stockCorrelation" action="stockCorrelation" method="post"
        theme="simple" namespace="/">
    <h4>Filters:</h4>
    <table>
        <tr>
            <td>Stock-1:</td>
            <td><s:select name="security1" list="securityList"
                          headerKey="1" /></td>
            <td>&nbsp;&nbsp;</td>
            <td>Price History:</td>
            <td><s:select name="priceHistoryField"
                          list="#{30:30, 60:60, 120:120, 250:250, 500:500}" headerKey="1" />
            </td>
        </tr>
        <tr>
            <td>Stock-2:</td>
            <td><s:select name="security2" list="securityList"
                          headerKey="1" /></td>
            <td>&nbsp;&nbsp;</td>
            <td>HV/Beta Period:</td>
            <td><s:select name="hvBetaPeriod"
                          list="#{20:20, 60:60, 120:120}" headerKey="2" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td colspan="2"><s:submit name="submit" /></td>
            <td>&nbsp;&nbsp;</td>
        </tr>
    </table>
</s:form>

<div style="font-size: 12pt; color: white; background-color: darkred">
    <s:actionerror />
    <s:fielderror />
    <s:actionmessage />
    <s:property value="fileNotFoundMessage" />
    <s:property value="errorMessage" />
</div>
<br>
<div style="font-size: 12pt; color: white; background-color: green">
    <s:property value="successUploadMessage" />
</div>
<p></p>

<h4>Results:</h4>
<!-- Results Output -->
<!-- Graph -->
<table>
    <tr>
        <td>
            <div id="graphdiv"></div>
        </td>
        <td>
            <div id="graphdiv2"></div>
        </td>
    </tr>
</table>
<script type="text/javascript">
    g = new Dygraph(
            // containing div
            document.getElementById("graphdiv"),
            // CSV or path to a CSV file.
            //"Date,<s:property value="sec1" default="stock1" />,<s:property value="sec2" default="stock2" />\n" +
            //"Date,Stock1,Stock2\n" +
            <s:iterator value="priceCompare">
            "<s:property value='value'/>\n"+
            </s:iterator>
            "<s:property value="%{priceCompare.['flag']}"/>\n",
            {
                showRoller: true,
                rollPeriod: 1,
                labels: [ 'Date', '<s:property value="sec1" default="stock1" />', '<s:property value="sec2" default="stock2" />' ],
                '<s:property value="sec1" default="stock1" />': {
                    axis: {
                    }
                },
                axes: {
                    '<s:property value="sec2" default="stock2" />': {
                        // set axis-related properties here
                        labelsKMB: true
                    }
                },
                xlabel: 'Date',
                ylabel: '<s:property value="sec1" default="stock2" />',
                y2label: '<s:property value="sec2" default="stock1" />',
                //yAxisLabelWidth: 60
            }
    );
    g2 = new Dygraph(document.getElementById("graphdiv2"),
            //"temperatures.csv", // path to CSV file
            "Date,Price Ratio\n" +
            <s:iterator value="priceRatio">
            "<s:property value='value'/>\n"+
            </s:iterator>
            "<s:property value="%{priceRatio.['flag']}"/>\n",
            {
                errorBars: true,
                showRoller: true,
                rollPeriod: 1
            }
    );

    function update(el) {
        g.updateOptions( { fillGraph: el.checked } );
        g2.updateOptions( { fillGraph: el.checked } );
    }
</script>
<input type=checkbox id="check" onChange="update(this)"> Fill?

<!-- stats -->
<div align="center">
    <table draggable="true" style="border-bottom: 1; border-color: red">
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><s:property value="sec1" /></td>
            <td>&nbsp;</td>
            <td><s:property value="sec2" /></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>Latest Price</td>
            <td>&nbsp;</td>
            <td><s:property value="latestPrice1" /></td>
            <td>&nbsp;</td>
            <td><s:property value="latestPrice2" /></td>
            <td>&nbsp;</td>
            <td>Current Ratio</td>
            <td><s:property value="latestPriceRatio" /></td>
        </tr>
        <tr>
            <td>HV</td>
            <td>&nbsp;</td>
            <td><s:property value="hv1" />%</td>
            <td>&nbsp;</td>
            <td><s:property value="hv2" />%</td>
            <td>&nbsp;</td>
            <td>Mean of Ratio</td>
            <td><s:property value="meanPriceRatio" /></td>
        </tr>
        <tr>
            <td>Beta to Index</td>
            <td>&nbsp;</td>
            <td><s:property value="beta1" /></td>
            <td>&nbsp;</td>
            <td><s:property value="beta2" /></td>
            <td>&nbsp;</td>
            <td>HV of Ratio</td>
            <td><s:property value="hvMeanRatio" /></td>
        </tr>
        <tr>
            <td>Corr to index</td>
            <td>&nbsp;</td>
            <td><s:property value="corr1" /></td>
            <td>&nbsp;</td>
            <td><s:property value="corr2" /></td>
            <td>&nbsp;</td>
            <td>Corr of <s:property value="sec2" default="stock2" /> to <s:property
                    value="sec1" default="stock1" />
            </td>
            <td><s:property value="correlation"/></td>
        </tr>
        <%--
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>Corr of Ratio to Index</td>
            <td><s:property value="corr2" /></td>
        </tr>
        --%>
    </table>
</div>
</body>
</html>