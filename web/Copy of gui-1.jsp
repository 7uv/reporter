<%@page import="com.sayantan.ActionForm.Gui2FormVars"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/global.css" />
<script src="src/dropdown.js" type="text/javascript"></script>
<script type="text/javascript" src="datepicker/datepickercontrol.js"></script>
<link type="text/css" rel="stylesheet"
	href="datepicker/datepickercontrol.css">
<link type="text/css" rel="stylesheet" href="css/displayDecorator.css">
<link type="text/css" rel="stylesheet" href="css/alternative.css">
<link type="text/css" rel="stylesheet" href="css/base.css">
<link type="text/css" rel="stylesheet" href="css/screen.css">
<link type="text/css" rel="stylesheet" href="css/global.css">
<title>Access Data Details</title>
</head>
<body>
	<!-- Input form -->
	<s:form name="accessReport" action="accessDetails" method="post"
		theme="simple" namespace="/">
		<h4>Filters:</h4>
		<table>
			<tr>
				<td>Sector:</td>
				<td><s:select name="sector" list="sectorList" headerKey="1" />
				</td>
				<td>&nbsp;&nbsp;</td>
				<td>F&O Only:</td>
				<td><s:checkbox name="fno" value="F & O Only" /></td>
			</tr>
			<tr>
				<td>Sub-Sector:</td>
				<td><s:select name="subSector" list="subSectorList"
						headerKey="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>Nifty Stocks:</td>
				<td><s:checkbox name="nstocks" value="Nifty Stocks" /></td>
			</tr>
			<tr>
				<td>Market Cap:</td>
				<td><s:textfield
						style="color: gray; font-style: oblique; font-weight:bold;"
						name="marketcap1" id="marketcap1" value="0" size="4" align="right" />
					&nbsp;<b>-</b>&nbsp; <s:textfield
						style="color: gray; font-style: oblique; font-weight:bold;"
						name="marketcap2" id="marketcap2" value="110000" size="4"
						align="right" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>All Stocks:</td>
				<td><s:checkbox name="astocks" value="All Stocks" /></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td align="left"><s:textfield type="text"
						id="DPC_calendar1c_DD-MM-YYYY" name="fromDate"
						style="color: gray; font-style: oblique; font-weight:bold;"
						size="8" /></td>
			</tr>
		</table>
		<h4>Display:</h4>
		<table>
			<tr>
				<td>HV</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>10</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="hv1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>20</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="hv2" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="hv3" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="hv4" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="hv5" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaDaily</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>20</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bd1" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bd2" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bd3" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bd4" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaDailyUp</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bdu1" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bdu2" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bdu3" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaDailyDown</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bdd1" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bdd2" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bdd3" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>Correlation</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>10</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="cor1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>20</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="cor2" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>40</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="cor3" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="cor4" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="cor5" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="cor6" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>WeeklyBeta</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>20</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="wb1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="wb2" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="wb3" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="wb4" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaWeeklyUp</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bwu1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bwu2" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bwu3" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaWeeklyDown</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bwd1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bwd2" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bwd3" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaMontly</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bm1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bm2" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bm3" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaMontlyUp</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bmu1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bmu2" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bmu3" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>BetaMonhtlyDown</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>60</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bmd1" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>120</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bmd2" value="0" /></td>
				<td>&nbsp;&nbsp;</td>
				<td>250</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:checkbox name="bmd3" value="1" /></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
		</table>

		<table border="0">
			<tr>
				<td colspan="2"><s:submit /></td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;</td>
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
	<!-- end edit -->
	<p></p>

	<!-- Results page -->
	<display:table id="lcp" name="lcp" pagesize="10"
		sort="list" export="true" requestURI="/accessDetails.action"
		cellspacing="10">
		<!-- Serial No. -->
		<% int countess = 0; %>
		<display:column  class="colId" title="" media="html" paramId="id"
			paramProperty="scenarioId" total="true" style="align:right">
			<!-- check out correct syntax for align -->
			<%--Integer.parseInt(pageContext.getAttribute(
							"lcp_rowNum").toString())--%>
		    <s:set name="rNum" value="%{lcp.row_rowNum}" />
		</display:column>

		<!-- Common fields -->	
		<display:column  class="colId" title="security" sortable="true" paramId="id"
			paramProperty="scenarioId" total="true">
					<%=TradeAppFormVars.getSecurity().get(
									Integer.parseInt(pageContext.getAttribute(
											"lcp_rowNum").toString()) - 1)%>
		</display:column>

		<c:if test="<%=TradeAppFormVars.getLastClosePrice().size() != 0%>">
			<display:column  class="colId" title="Last Price" sortable="true" paramId="lcp"
				paramProperty="lcp" escapeXml="true" headerClass="sortable">
				<%=TradeAppFormVars.getLastClosePrice().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getMc().size() != 0%>">
			<display:column  class="colId" title="MC" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getMc().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<!-- Historical Volatility -->
		<c:if test="<%=TradeAppFormVars.getHv1list().size() != 0%>">
			<display:column  class="colId" title="HV10" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getHv1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getHv2list().size() != 0%>">
			<display:column  class="colId" title="HV20" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getHv2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getHv3list().size() != 0%>">
			<display:column  class="colId" title="HV60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getHv3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>

		</c:if>
		<c:if test="<%=TradeAppFormVars.getHv4list().size() != 0%>">
			<display:column  class="colId" title="HV120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getHv4list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getHv5list().size() != 0%>">
			<display:column  class="colId" title="HV250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getHv5list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<!-- Beta Daily -->
		<c:if test="<%=TradeAppFormVars.getBd1list().size() != 0%>">
			<display:column  class="colId" title="BD20" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBd1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getBd2list().size() != 0%>">
			<display:column  class="colId" title="BD60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBd2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getBd3list().size() != 0%>">
			<display:column  class="colId" title="BD120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBd3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getBd4list().size() != 0%>">
			<display:column  class="colId" title="BD250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBd4list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<!-- Beta Daily Up -->
		<c:if test="<%=TradeAppFormVars.getBdu1list().size() != 0%>">
			<display:column  class="colId" title="BDU60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBdu1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getBdu2list().size() != 0%>">
			<display:column  class="colId" title="BDU120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBdu2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getBdu3list().size() != 0%>">
			<display:column  class="colId" title="BDU250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBdu3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<!-- Beta Daily Down -->
		<c:if test="<%=TradeAppFormVars.getBdd1list().size() != 0%>">
			<display:column  class="colId" title="BDD60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBdd1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
			
		<c:if test="<%=TradeAppFormVars.getBdd2list().size() != 0%>">
			<display:column  class="colId" title="BDD120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBdd2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getBdd3list().size() != 0%>">
			<display:column  class="colId" title="BDD250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBdd3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<!-- Correlation -->
		<c:if test="<%=TradeAppFormVars.getCorr1list().size() != 0%>">
			<display:column  class="colId" title="Corr10" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getCorr1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
			
		<c:if test="<%=TradeAppFormVars.getCorr2list().size() != 0%>">
			<display:column  class="colId" title="Corr20" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getCorr2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getCorr3list().size() != 0%>">
			<display:column  class="colId" title="Corr40" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getCorr3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getCorr4list().size() != 0%>">
			<display:column  class="colId" title="Corr60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getCorr4list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getCorr5list().size() != 0%>">
			<display:column  class="colId" title="Correlation120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getCorr5list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<c:if test="<%=TradeAppFormVars.getCorr6list().size() != 0%>">
			<display:column  class="colId" title="Corr250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getCorr6list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<!-- Weekly Beta -->				
		<c:if test="<%=TradeAppFormVars.getWb1list().size() != 0%>">
			<display:column  class="colId" title="WB20" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getWb1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getWb2list().size() != 0%>">
			<display:column  class="colId" title="WB60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getWb2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getWb3list().size() != 0%>">
			<display:column  class="colId" title="WB120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getWb3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getWb4list().size() != 0%>">
			<display:column  class="colId" title="WB250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getWb4list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
			
		<!-- Beta Weekly Up -->			
		<c:if test="<%=TradeAppFormVars.getBwu1list().size() != 0%>">
			<display:column  class="colId" title="BWU60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBwu1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getBwu2list().size() != 0%>">
			<display:column  class="colId" title="BWU120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBwu2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getBwu3list().size() != 0%>">
			<display:column  class="colId" title="BWU250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBwu3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<!-- Beta Weekly Down -->			
		<c:if test="<%=TradeAppFormVars.getBwd1list().size() != 0%>">
			<display:column  class="colId" title="BWD60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBwd1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getBwd2list().size() != 0%>">
			<display:column  class="colId" title="BWD120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBwd2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getBwd3list().size() != 0%>">
			<display:column  class="colId" title="BWD250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBwd3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<!-- Beta Monthly -->				
		<c:if test="<%=TradeAppFormVars.getBm1list().size() != 0%>">
			<display:column  class="colId" title="BM60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBm1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getBm2list().size() != 0%>">
			<display:column  class="colId" title="BM120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBm2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
						
		<c:if test="<%=TradeAppFormVars.getBm3list().size() != 0%>">
			<display:column  class="colId" title="BM250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBm3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<!-- Beta Monthly Up -->
		<c:if test="<%=TradeAppFormVars.getBmu1list().size() != 0%>">
			<display:column  class="colId" title="BMU60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBmu1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<c:if test="<%=TradeAppFormVars.getBmu2list().size() != 0%>">
			<display:column  class="colId" title="BMU120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBmu2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<c:if test="<%=TradeAppFormVars.getBmu3list().size() != 0%>">
			<display:column  class="colId" title="BMU250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBmu3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		
		<!-- Beta Monthly Down -->
		<c:if test="<%=TradeAppFormVars.getBmd1list().size() != 0%>">
			<display:column  class="colId" title="BD60" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBmd1list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<c:if test="<%=TradeAppFormVars.getBmd2list().size() != 0%>">
			<display:column  class="colId" title="BMD120" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBmd2list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>

		<c:if test="<%=TradeAppFormVars.getBmd3list().size() != 0%>">
			<display:column  class="colId" title="BMD250" sortable="true" paramId="id"
				paramProperty="scenarioId">
				<%=TradeAppFormVars.getBmd3list().get(
								Integer.parseInt(pageContext.getAttribute(
										"lcp_rowNum").toString()) - 1)%>
			</display:column>
		</c:if>
		
		<display:column>
		</display:column>

		<!-- Footer -->
		<br>
		<br>
		<%-- <display:caption><h3>Trade Details</h3></display:caption> --%>
		<display:setProperty name="paging.banner.placement" value="bottom" />
	</display:table>

</body>
</html>