(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[25],{ZWZp:function(t,e,n){"use strict";n.r(e);n("Mwp2");var a,i,r=n("VXEj"),o=(n("IzEo"),n("bx4M")),c=(n("sPJy"),n("bE4q")),s=(n("Pwec"),n("CtXQ")),l=n("2Taf"),m=n.n(l),u=n("vZ4D"),d=n.n(u),p=n("l4Ni"),E=n.n(p),h=n("ujKo"),f=n.n(h),b=n("MhPg"),g=n.n(b),v=n("q1tI"),w=n.n(v),M=n("tj8u"),L=n.n(M),y=n("MuoO"),I="landingEditorCommittee",j=function(t){var e=t[I].editorList;return{editorList:e}},k=function(t){return{onDidMount:function(){t({type:"".concat(I,"/queryEditorList")})}}},D=(a=Object(y["connect"])(j,k),a(i=function(t){function e(t){var n;return m()(this,e),n=E()(this,f()(e).call(this,t)),n.state={editorList:[]},n}return g()(e,t),d()(e,[{key:"componentDidMount",value:function(){this.props.onDidMount(),this.setState({editorList:this.props.editorList})}},{key:"render",value:function(){return w.a.createElement("div",null,w.a.createElement(c["a"],{className:L.a.breadcrumb},w.a.createElement(c["a"].Item,{href:"/"},w.a.createElement(s["a"],{type:"home"})),w.a.createElement(c["a"].Item,null,"\u7f16\u59d4\u4f1a\u540d\u5355")),w.a.createElement("div",{className:L.a.title},"\u7f16\u59d4\u4f1a\u540d\u5355"),w.a.createElement("div",{className:L.a.content},w.a.createElement(r["a"],{grid:{gutter:16,column:4},dataSource:this.state.editorList,renderItem:function(t){return w.a.createElement(r["a"].Item,null,w.a.createElement(o["a"],{cover:w.a.createElement("img",{alt:"\u7167\u7247\u6682\u65e0",src:t.photo})},w.a.createElement(o["a"].Meta,{title:t.name,description:t.duties.concat("<br />").concat(t.description)})))}})))}}]),e}(w.a.Component))||i);e["default"]=D},tj8u:function(t,e,n){t.exports={title:"antd-pro-pages-home-landing-editor-committee-list-title",breadcrumb:"antd-pro-pages-home-landing-editor-committee-list-breadcrumb",content:"antd-pro-pages-home-landing-editor-committee-list-content"}}}]);