(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[26],{"6Hox":function(e,t,n){e.exports={title:"antd-pro-pages-home-landing-file-list-title",breadcrumb:"antd-pro-pages-home-landing-file-list-breadcrumb",content:"antd-pro-pages-home-landing-file-list-content"}},D7OV:function(e,t,n){"use strict";n.r(t);n("Mwp2");var a,i,o=n("VXEj"),l=(n("sPJy"),n("bE4q")),c=(n("Pwec"),n("CtXQ")),r=n("2Taf"),s=n.n(r),u=n("vZ4D"),d=n.n(u),m=n("l4Ni"),f=n.n(m),p=n("ujKo"),h=n.n(p),b=n("MhPg"),v=n.n(b),w=n("q1tI"),y=n.n(w),E=n("wd/R"),g=n.n(E),L=n("6Hox"),D=n.n(L),k=n("MuoO"),M="landingFileList",C=function(e){var t=e[M].fileList;return{fileList:t}},I=function(e){return{onDidMount:function(){e({type:"".concat(M,"/queryFileList")})},getFile:function(t,n){e({type:"".concat(namespaceDownload,"/queryFile"),payload:{filename:filename,format:format,type:n}})}}},j=(a=Object(k["connect"])(C,I),a(i=function(e){function t(e){var n;return s()(this,t),n=f()(this,h()(t).call(this,e)),n.state={fileList:[]},n}return v()(t,e),d()(t,[{key:"componentDidMount",value:function(){this.props.onDidMount(),this.setState({fileList:this.props.fileList})}},{key:"getDownloadLink",value:function(e){fetch("/file/download/id=".concat(e,"&type=4")).then(function(e){e.blob().then(function(t){var n=document.createElement("a");document.body.appendChild(n),n.style.display="none";var a=window.URL.createObjectURL(t);n.href=a,n.download=e.headers.get("Content-Disposition").split(";")[1].split("filename=")[1],n.click(),document.body.removeChild(n)})})}},{key:"render",value:function(){var e=this;return y.a.createElement("div",null,y.a.createElement("div",{className:D.a.breadcrumb},y.a.createElement(l["a"],null,y.a.createElement(l["a"].Item,{href:"/"},y.a.createElement(c["a"],{type:"home"})),y.a.createElement(l["a"].Item,null,"\u8d44\u6599\u4e0b\u8f7d"))),y.a.createElement("div",{className:D.a.title},"\u8d44\u6599\u4e0b\u8f7d"),y.a.createElement("div",{className:D.a.content},y.a.createElement(o["a"],{dataSource:this.props.fileList,renderItem:function(t){return y.a.createElement(o["a"].Item,null,y.a.createElement(o["a"].Item.Meta,{title:y.a.createElement("a",{onClick:function(){return e.getDownloadLink(t.id)}},t.name)}),y.a.createElement("div",null,g()(t.date_pub).format("YYYY-MM-DD")))}})))}}]),t}(y.a.Component))||i);t["default"]=j}}]);