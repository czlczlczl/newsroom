(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[31],{"63cc":function(e,t,n){e.exports={title:"antd-pro-pages-home-landing-article-title",breadcrumb:"antd-pro-pages-home-landing-article-breadcrumb",meta:"antd-pro-pages-home-landing-article-meta",CardCss:"antd-pro-pages-home-landing-article-CardCss",text:"antd-pro-pages-home-landing-article-text",img:"antd-pro-pages-home-landing-article-img"}},joGr:function(e,t,n){"use strict";n.r(t);n("sPJy");var a,o,i=n("bE4q"),c=(n("Pwec"),n("CtXQ")),l=(n("T2oS"),n("W9HT")),r=n("2Taf"),s=n.n(r),u=n("vZ4D"),d=n.n(u),m=n("l4Ni"),p=n.n(m),h=n("ujKo"),f=n.n(h),g=n("MhPg"),v=n.n(g),b=n("q1tI"),E=n.n(b),w=n("wd/R"),y=n.n(w),J=n("MuoO"),C=n("63cc"),k=n.n(C),D="landingCurrentArticle",L=function(e){var t=e[D].resultJson;return{resultJson:t}},M=function(e){return{onDidMount:function(t){e({type:"".concat(D,"/queryArticle"),payload:t})}}},j=(a=Object(J["connect"])(L,M),a(o=function(e){function t(e){var n;return s()(this,t),n=p()(this,f()(t).call(this,e)),n.state={resultJson:{},isLoading:!0},n}return v()(t,e),d()(t,[{key:"componentDidMount",value:function(){var e=this;fetch("/common/getannouncement/id=".concat(this.props.match.params.id)).then(function(e){return e.json()}).then(function(t){e.setState({resultJson:t,isLoading:!1})})}},{key:"getDownloadLink",value:function(e){fetch("/file/download/id=".concat(e,"&type=3")).then(function(e){e.blob().then(function(t){var n=document.createElement("a");document.body.appendChild(n),n.style.display="none";var a=window.URL.createObjectURL(t);n.href=a,n.download=e.headers.get("Content-Disposition").split(";")[1].split("filename=")[1],n.click(),document.body.removeChild(n)})})}},{key:"render",value:function(){var e=this;return this.state.isLoading?E.a.createElement(l["a"],null):E.a.createElement("div",null,E.a.createElement("div",{className:k.a.breadcrumb},E.a.createElement(i["a"],null,E.a.createElement(i["a"].Item,{href:"/"},E.a.createElement(c["a"],{type:"home"})),E.a.createElement(i["a"].Item,null,"\u516c\u544a\u5217\u8868"),E.a.createElement(i["a"].Item,null,this.state.resultJson.announcement.title))),E.a.createElement("div",{className:k.a.title},this.state.resultJson.announcement.title),E.a.createElement("div",{className:k.a.meta},"\u4e0a\u4f20\u65f6\u95f4\uff1a",y()(this.state.resultJson.announcement.date_pub).format("YYYY-MM-DD")),E.a.createElement("div",{className:k.a.text},this.state.resultJson.announcement.content),E.a.createElement("div",null,E.a.createElement("a",{onClick:function(){e.getDownloadLink(e.state.resultJson.announcement.id)}},"\u4e0b\u8f7d\u9644\u4ef6")))}}]),t}(E.a.Component))||o);t["default"]=j}}]);