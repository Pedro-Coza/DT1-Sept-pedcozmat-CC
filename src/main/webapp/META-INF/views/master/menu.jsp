<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="https://es.wikipedia.org/wiki/N%C3%BAmero_de_Cullen"/>
			<acme:menu-suboption code="master.menu.anonymous.bulletin.list" action="/anonymous/bulletin/list"/>
			<acme:menu-suboption code="master.menu.anonymous.bulletin.create" action="/anonymous/bulletin/create"/>
			<acme:menu-suboption code="master.menu.anonymous.notice.list" action="/anonymous/notice/list"/>
			<acme:menu-suboption code="master.menu.anonymous.techRecord.list" action="/anonymous/technology-record/list"/>
			<acme:menu-suboption code="master.menu.anonymous.toolRecord.list" action="/anonymous/tool-record/list"/>
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.notice" action="/administrator/notice/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.spamlist" action="/administrator/spamlist/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.challenge.list" action="/administrator/challenge/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.notice.list" action="/administrator/notice/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.technologyRecord.list" action="/administrator/technology-record/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.toolRecord.list" action="/administrator/tool-record/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.inquiry.list" action="/administrator/inquiry/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.overture.list" action="/administrator/overture/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.notice.list" action="/authenticated/notice/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.techRecord.list" action="/authenticated/technology-record/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.toolRecord.list" action="/authenticated/tool-record/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.inquiry.list" action="/authenticated/inquiry/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.overture.list" action="/authenticated/overture/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.challenge.list" action="/authenticated/challenge/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.investmentRound.list" action="/authenticated/investment-round/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.forum.list" action="/authenticated/forum/list_mine"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.enterpreneur" access="hasRole('Enterpreneur')">
			<acme:menu-suboption code="master.menu.enterpreneur.investmentRound.create" action="/enterpreneur/investment-round/create"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.enterpreneur.investmentRound.list" action="/enterpreneur/investment-round/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.enterpreneur.application.listMine" action="/enterpreneur/application/list_mine"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.forum.list" action="/enterpreneur/forum/list_mine"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.enterpreneur.application.listDate" action="/enterpreneur/application/list_date"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.enterpreneur.application.listTicker" action="/enterpreneur/application/list_ticker"/>
		</acme:menu-option>
		
		
		<acme:menu-option code="master.menu.investor" access="hasRole('Investor')">
			<acme:menu-suboption code="master.menu.investor.application.listMine" action="/investor/application/list_mine"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.investor.investmentRound.list" action="/investor/investment-round/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.forum.list" action="/investor/forum/list_mine"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.bookkeeper" access="hasRole('Bookkeeper')">
			<acme:menu-suboption code="master.menu.bookkeeper.investment-round.listMine" action="/bookkeeper/investment-round/list_mine"/>
			<acme:menu-suboption code="master.menu.bookkeeper.investment-round.listNotMine" action="/bookkeeper/investment-round/list_not_mine"/>
		</acme:menu-option>
		
		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.banner.list" action="/patron/banner/list"/>
		</acme:menu-option>
		
		
		
		
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-enterpreneur" action="/authenticated/enterpreneur/create" access="!hasRole('Enterpreneur')"/>
			<acme:menu-suboption code="master.menu.user-account.become-investor" action="/authenticated/investor/create" access="!hasRole('Investor')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

