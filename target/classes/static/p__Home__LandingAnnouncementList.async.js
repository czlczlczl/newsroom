(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[23],{"57Qp":function(e,n,t){"use strict";t.r(n);t("Mwp2");var a,r,o=t("VXEj"),c=(t("sPJy"),t("bE4q")),i=(t("Pwec"),t("CtXQ")),l=t("2Taf"),u=t.n(l),s=t("vZ4D"),m=t.n(s),d=t("l4Ni"),p=t.n(d),f=t("ujKo"),v=t.n(f),b=t("MhPg"),h=t.n(b),E=t("q1tI"),g=t.n(E),w=t("wd/R"),M=t.n(w),y=t("MuoO"),D=t("vQUR"),I=t.n(D),R="AnnouncementList",L=function(e){var n=e[R].processResult;return{processResult:n}},k=function(e){return{onDidMount:function(){e({type:"".concat(R,"/queryList"),payload:-1})}}},N=(a=Object(y["connect"])(L,k),a(r=function(e){function n(){return u()(this,n),p()(this,v()(n).apply(this,arguments))}return h()(n,e),m()(n,[{key:"componentDidMount",value:function(){this.props.onDidMount()}},{key:"render",value:function(){var e=this.props.processResult,n=[];if(1==e.result)for(var t=0;t<e.announcementlist.length;t++){var a={title:e.announcementlist[t].title,url:"/landing/announcement/".concat(e.announcementlist[t].id),date_pub:e.announcementlist[t].date_pub},r=n.concat(a);n=r}return g.a.createElement("div",null,g.a.createElement(c["a"],{className:I.a.breadcrumb},g.a.createElement(c["a"].Item,{href:"/"},g.a.createElement(i["a"],{type:"home"})),g.a.createElement(c["a"].Item,null,"\u7f16\u8f91\u90e8\u516c\u544a")),g.a.createElement("div",{className:I.a.title},"\u7f16\u8f91\u90e8\u516c\u544a"),g.a.createElement("div",{className:I.a.divList},g.a.createElement(o["a"],{bordered:!0,dataSource:n,renderItem:function(e){return g.a.createElement(o["a"].Item,null,g.a.createElement(o["a"].Item.Meta,{title:g.a.createElement("a",{href:e.url},e.title)}),g.a.createElement("div",null,M()(e.date_pub).format("YYYY-MM-DD")))}})))}}]),n}(g.a.Component))||r);n["default"]=N},vQUR:function(e,n,t){e.exports={title:"antd-pro-pages-home-landing-announcement-list-title",breadcrumb:"antd-pro-pages-home-landing-announcement-list-breadcrumb",divList:"antd-pro-pages-home-landing-announcement-list-divList"}}}]);