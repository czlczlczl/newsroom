(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[6],{AKKm:function(e,t,a){},JDLn:function(e,t,a){e.exports={toolbar:"antd-pro-components-footer-toolbar-index-toolbar",left:"antd-pro-components-footer-toolbar-index-left",right:"antd-pro-components-footer-toolbar-index-right"}},l6y1:function(e,t,a){e.exports={card:"antd-pro-pages-author-submit-new-article-card",heading:"antd-pro-pages-author-submit-new-article-heading",steps:"antd-pro-pages-author-submit-new-article-steps",errorIcon:"antd-pro-pages-author-submit-new-article-errorIcon",errorPopover:"antd-pro-pages-author-submit-new-article-errorPopover",errorListItem:"antd-pro-pages-author-submit-new-article-errorListItem",errorField:"antd-pro-pages-author-submit-new-article-errorField",editable:"antd-pro-pages-author-submit-new-article-editable",advancedForm:"antd-pro-pages-author-submit-new-article-advancedForm",optional:"antd-pro-pages-author-submit-new-article-optional"}},rD0X:function(e,t,a){"use strict";a.r(t);a("+L6B");var n=a("2/Rp"),r=(a("IzEo"),a("bx4M")),l=(a("14J3"),a("BMrR")),o=(a("jCWc"),a("kPKH")),i=(a("5NDa"),a("5rEg")),c=(a("OaEy"),a("2fM7")),s=(a("miYZ"),a("tsqr")),u=a("2Taf"),m=a.n(u),d=a("vZ4D"),p=a.n(d),f=a("l4Ni"),h=a.n(f),y=a("ujKo"),v=a.n(y),g=a("MhPg"),b=a.n(g),E=(a("y8nQ"),a("Vl3Y")),w=a("q1tI"),k=a.n(w),C=a("MuoO"),_=a("usdK"),F=a("zHco"),O=a("jehZ"),S=a.n(O),x=a("Y/ft"),D=a.n(x),P=a("17x9"),I=a.n(P),N=a("TSYQ"),T=a.n(N),j=a("JDLn"),K=a.n(j),z=function(e){function t(){var e,a;m()(this,t);for(var n=arguments.length,r=new Array(n),l=0;l<n;l++)r[l]=arguments[l];return a=h()(this,(e=v()(t)).call.apply(e,[this].concat(r))),a.state={width:void 0},a.resizeFooterToolbar=function(){var e=document.querySelector(".ant-layout-sider");if(null!=e){var t=a.context.isMobile,n=t?null:"calc(100% - ".concat(e.style.width,")"),r=a.state.width;r!==n&&a.setState({width:n})}},a}return b()(t,e),p()(t,[{key:"componentDidMount",value:function(){window.addEventListener("resize",this.resizeFooterToolbar),this.resizeFooterToolbar()}},{key:"componentWillUnmount",value:function(){window.removeEventListener("resize",this.resizeFooterToolbar)}},{key:"render",value:function(){var e=this.props,t=e.children,a=e.className,n=e.extra,r=D()(e,["children","className","extra"]),l=this.state.width;return k.a.createElement("div",S()({className:T()(a,K.a.toolbar),style:{width:l}},r),k.a.createElement("div",{className:K.a.left},n),k.a.createElement("div",{className:K.a.right},t))}}]),t}(w["Component"]);z.contextTypes={isMobile:I.a.bool};a("g9YV");var L=a("wCAj"),q=(a("cIOH"),a("Q9mQ"),a("VCL8")),V=a("3S7+"),B=a("CtXQ"),M=a("YMnH"),R=a("Kz+r"),A=a("wEI+");function J(e){return J="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"===typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},J(e)}function Y(){return Y=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var n in a)Object.prototype.hasOwnProperty.call(a,n)&&(e[n]=a[n])}return e},Y.apply(this,arguments)}function Q(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function H(e,t){for(var a=0;a<t.length;a++){var n=t[a];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(e,n.key,n)}}function W(e,t,a){return t&&H(e.prototype,t),a&&H(e,a),e}function Z(e,t){return!t||"object"!==J(t)&&"function"!==typeof t?X(e):t}function U(e){return U=Object.setPrototypeOf?Object.getPrototypeOf:function(e){return e.__proto__||Object.getPrototypeOf(e)},U(e)}function X(e){if(void 0===e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return e}function G(e,t){if("function"!==typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function");e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,writable:!0,configurable:!0}}),t&&$(e,t)}function $(e,t){return $=Object.setPrototypeOf||function(e,t){return e.__proto__=t,e},$(e,t)}var ee=function(e,t){var a={};for(var n in e)Object.prototype.hasOwnProperty.call(e,n)&&t.indexOf(n)<0&&(a[n]=e[n]);if(null!=e&&"function"===typeof Object.getOwnPropertySymbols){var r=0;for(n=Object.getOwnPropertySymbols(e);r<n.length;r++)t.indexOf(n[r])<0&&(a[n[r]]=e[n[r]])}return a},te=function(e){function t(e){var a;return Q(this,t),a=Z(this,U(t).call(this,e)),a.onConfirm=function(e){a.setVisible(!1,e);var t=a.props.onConfirm;t&&t.call(X(a),e)},a.onCancel=function(e){a.setVisible(!1,e);var t=a.props.onCancel;t&&t.call(X(a),e)},a.onVisibleChange=function(e){a.setVisible(e)},a.saveTooltip=function(e){a.tooltip=e},a.renderOverlay=function(e,t){var r=a.props,l=r.okButtonProps,o=r.cancelButtonProps,i=r.title,c=r.cancelText,s=r.okText,u=r.okType,m=r.icon;return w["createElement"]("div",null,w["createElement"]("div",{className:"".concat(e,"-inner-content")},w["createElement"]("div",{className:"".concat(e,"-message")},m,w["createElement"]("div",{className:"".concat(e,"-message-title")},i)),w["createElement"]("div",{className:"".concat(e,"-buttons")},w["createElement"](n["a"],Y({onClick:a.onCancel,size:"small"},o),c||t.cancelText),w["createElement"](n["a"],Y({onClick:a.onConfirm,type:u,size:"small"},l),s||t.okText))))},a.renderConfirm=function(e){var t=e.getPrefixCls,n=a.props,r=n.prefixCls,l=n.placement,o=ee(n,["prefixCls","placement"]),i=t("popover",r),c=w["createElement"](M["a"],{componentName:"Popconfirm",defaultLocale:R["a"].Popconfirm},function(e){return a.renderOverlay(i,e)});return w["createElement"](V["a"],Y({},o,{prefixCls:i,placement:l,onVisibleChange:a.onVisibleChange,visible:a.state.visible,overlay:c,ref:a.saveTooltip}))},a.state={visible:e.visible},a}return G(t,e),W(t,[{key:"getPopupDomNode",value:function(){return this.tooltip.getPopupDomNode()}},{key:"setVisible",value:function(e,t){var a=this.props;"visible"in a||this.setState({visible:e});var n=a.onVisibleChange;n&&n(e,t)}},{key:"render",value:function(){return w["createElement"](A["a"],null,this.renderConfirm)}}],[{key:"getDerivedStateFromProps",value:function(e){return"visible"in e?{visible:e.visible}:"defaultVisible"in e?{visible:e.defaultVisible}:null}}]),t}(w["Component"]);te.defaultProps={transitionName:"zoom-big",placement:"top",trigger:"click",okType:"primary",icon:w["createElement"](B["a"],{type:"exclamation-circle",theme:"filled"})},Object(q["polyfill"])(te);var ae,ne,re,le,oe=te,ie=(a("/zsF"),a("PArb")),ce=a("p0pE"),se=a.n(ce),ue=a("Y+p1"),me=a.n(ue),de=a("AKKm"),pe=a.n(de),fe=function(e){function t(e){var a;return m()(this,t),a=h()(this,v()(t).call(this,e)),a.index=0,a.cacheOriginData={},a.toggleEditable=function(e,t){e.preventDefault();var n=a.state.data,r=n.map(function(e){return se()({},e)}),l=a.getRowByKey(t,r);l&&(l.editable||(a.cacheOriginData[t]=se()({},l)),l.editable=!l.editable,a.setState({data:r}))},a.newMember=function(){var e=a.state.data,t=e.map(function(e){return se()({},e)});t.push({key:"NEW_TEMP_ID_".concat(a.index),name:"",institution:"",email:"",editable:!0,isNew:!0}),a.index+=1,a.setState({data:t})},a.state={data:e.value,loading:!1,value:e.value},a}return b()(t,e),p()(t,[{key:"getRowByKey",value:function(e,t){var a=this.state.data;return(t||a).filter(function(t){return t.key===e})[0]}},{key:"remove",value:function(e){var t=this.state.data,a=this.props.onChange,n=t.filter(function(t){return t.key!==e});this.setState({data:n}),a(n)}},{key:"handleKeyPress",value:function(e,t){"Enter"===e.key&&this.saveRow(e,t)}},{key:"handleFieldChange",value:function(e,t,a){var n=this.state.data,r=n.map(function(e){return se()({},e)}),l=this.getRowByKey(a,r);l&&(l[t]=e.target.value,this.setState({data:r}))}},{key:"saveRow",value:function(e,t){var a=this;e.persist(),this.setState({loading:!0}),setTimeout(function(){if(a.clickedCancel)a.clickedCancel=!1;else{var n=a.getRowByKey(t)||{};if(!n.name||!n.institution||!n.email)return s["a"].error("\u8bf7\u586b\u5199\u5b8c\u6574\u7684\u4f5c\u8005\u4fe1\u606f\u3002"),e.target.focus(),void a.setState({loading:!1});delete n.isNew,a.toggleEditable(e,t);var r=a.state.data,l=a.props.onChange;l(r),a.setState({loading:!1})}},500)}},{key:"cancel",value:function(e,t){this.clickedCancel=!0,e.preventDefault();var a=this.state.data,n=a.map(function(e){return se()({},e)}),r=this.getRowByKey(t,n);this.cacheOriginData[t]&&(Object.assign(r,this.cacheOriginData[t]),delete this.cacheOriginData[t]),r.editable=!1,this.setState({data:n}),this.clickedCancel=!1}},{key:"render",value:function(){var e=this,t=[{title:"\u4f5c\u8005",dataIndex:"name",key:"name",width:"20%",render:function(t,a){return a.editable?k.a.createElement(i["a"],{value:t,autoFocus:!0,onChange:function(t){return e.handleFieldChange(t,"name",a.key)},onKeyPress:function(t){return e.handleKeyPress(t,a.key)},placeholder:"\u4f5c\u8005"}):t}},{title:"\u5de5\u4f5c\u5355\u4f4d",dataIndex:"institution",key:"institution",width:"20%",render:function(t,a){return a.editable?k.a.createElement(i["a"],{value:t,onChange:function(t){return e.handleFieldChange(t,"institution",a.key)},onKeyPress:function(t){return e.handleKeyPress(t,a.key)},placeholder:"\u5de5\u4f5c\u5355\u4f4d"}):t}},{title:"\u90ae\u7bb1",dataIndex:"email",key:"email",width:"40%",render:function(t,a){return a.editable?k.a.createElement(i["a"],{value:t,onChange:function(t){return e.handleFieldChange(t,"email",a.key)},onKeyPress:function(t){return e.handleKeyPress(t,a.key)},placeholder:"\u90ae\u7bb1"}):t}},{title:"\u64cd\u4f5c",key:"action",render:function(t,a){var n=e.state.loading;return a.editable&&n?null:a.editable?a.isNew?k.a.createElement("span",null,k.a.createElement("a",{onClick:function(t){return e.saveRow(t,a.key)}},"\u6dfb\u52a0"),k.a.createElement(ie["a"],{type:"vertical"}),k.a.createElement(oe,{title:"\u662f\u5426\u8981\u5220\u9664\u6b64\u884c\uff1f",onConfirm:function(){return e.remove(a.key)}},k.a.createElement("a",null,"\u5220\u9664"))):k.a.createElement("span",null,k.a.createElement("a",{onClick:function(t){return e.saveRow(t,a.key)}},"\u4fdd\u5b58"),k.a.createElement(ie["a"],{type:"vertical"}),k.a.createElement("a",{onClick:function(t){return e.cancel(t,a.key)}},"\u53d6\u6d88")):k.a.createElement("span",null,k.a.createElement("a",{onClick:function(t){return e.toggleEditable(t,a.key)}},"\u7f16\u8f91"),k.a.createElement(ie["a"],{type:"vertical"}),k.a.createElement(oe,{title:"\u662f\u5426\u8981\u5220\u9664\u6b64\u884c\uff1f",onConfirm:function(){return e.remove(a.key)}},k.a.createElement("a",null,"\u5220\u9664")))}}],a=this.state,r=a.loading,l=a.data;return k.a.createElement(w["Fragment"],null,k.a.createElement(L["a"],{loading:r,columns:t,dataSource:l,pagination:!1,rowClassName:function(e){return e.editable?pe.a.editable:""}}),k.a.createElement(n["a"],{style:{width:"100%",marginTop:16,marginBottom:8},type:"dashed",onClick:this.newMember,icon:"plus"},"\u65b0\u589e\u6210\u5458"))}}],[{key:"getDerivedStateFromProps",value:function(e,t){return me()(e.value,t.value)?null:{data:e.value,value:e.value}}}]),t}(w["PureComponent"]),he=fe,ye=a("l6y1"),ve=a.n(ye),ge="academicSection",be="column",Ee=function(e){var t=e[ge].list,a=e[be].typelist;return{academicSec:t,columnList:a}},we=(ae=Object(C["connect"])(Ee,null),ne=E["a"].create(),ae(re=ne((le=function(e){function t(e){var a;return m()(this,t),a=h()(this,v()(t).call(this,e)),a.resizeFooterToolbar=function(){requestAnimationFrame(function(){var e=document.querySelectorAll(".ant-layout-sider")[0];if(e){var t="calc(100% - ".concat(e.style.width,")"),n=a.state.width;n!==t&&a.setState({width:t})}})},a.validate=function(e){e.preventDefault();var t=a.props,n=t.form.validateFieldsAndScroll;t.dispatch;n(function(e,t){if(!e){var n=new FormData,r={article:{}};r.article.title=t.title,r.article.academicsec=t.academicsec,r.article.column=t.column,r.article.keyword1_cn=t.keyword1_cn,r.article.keyword2_cn=t.keyword2_cn?t.keyword2_ch:"",r.article.keyword3_cn=t.keyword3_cn?t.keyword3_ch:"",r.article.keyword4_cn=t.keyword4_cn?t.keyword4_ch:"",r.article.keyword1_en=t.keyword1_en,r.article.keyword2_en=t.keyword2_en?t.keyword2_en:"",r.article.keyword3_en=t.keyword3_en?t.keyword3_en:"",r.article.keyword4_en=t.keyword4_en?t.keyword4_en:"",r.article.summary_cn=t.summary_cn,r.article.summary_en=t.summary_en;for(var l=[],o=0;o<t.author.length;o++){var i={name:t.author[o].name,institution:t.author[o].institution,email:t.author[o].email};l.push(i)}if(r.article.writers_info=l,!a.state.filename1||""==a.state.filename1)return void s["a"].error("\u8bf7\u4e0a\u4f20\u6587\u7ae0\u6587\u4ef6");var c=a.state.filename1.substr(a.state.filename1.lastIndexOf("."));if(a.state.filename2&&""!=a.state.filename2){var u=a.state.filename2.substr(a.state.filename2.lastIndexOf("."));r.article.format=c.concat(";").concat(u),n.append("file1",a.state.file1),n.append("file2",a.state.file2),n.append("all",JSON.stringify(r))}else r.article.format=c,n.append("file1",a.state.file1),n.append("all",JSON.stringify(r));fetch("/contribute/upload_allocate",{method:"POST",header:{"Content-Type":"multipart/form-data"},credentials:"include",body:n}).then(function(e){return e.json()}).then(function(e){1==e.result?_["a"].push("/author/result"):s["a"].error("\u63d0\u4ea4\u9519\u8bef")})}})},a.generateAcademicSec=function(){if(!a.props.academicSec)return null;for(var e=[],t=0;t<a.props.academicSec.length;t++)e.push(k.a.createElement(c["a"].Option,{value:a.props.academicSec[t].id},a.props.academicSec[t].academicsec));return e},a.generateColumn=function(){if(!a.props.columnList)return null;for(var e=[],t=0;t<a.props.columnList.length;t++)e.push(k.a.createElement(c["a"].Option,{value:a.props.columnList[t].id},a.props.columnList[t].column));return e},a.uploadFile1=function(e){e.preventDefault(),a.refs.uploadBox1.click()},a.uploadFile2=function(e){e.preventDefault(),a.refs.uploadBox2.click()},a.onFileChange1=function(e){var t=e.target.files[0];a.setState({file1:t,filename1:t?t.name:null})},a.onFileChange2=function(e){var t=e.target.files[0];a.setState({file2:t,filename2:t?t.name:null})},a.state={file1:void 0,filename1:void 0,width:"100%",file2:void 0,filename2:void 0},a}return b()(t,e),p()(t,[{key:"componentDidMount",value:function(){this.props.dispatch({type:"".concat(ge,"/queryList")}),this.props.dispatch({type:"".concat(be,"/queryCol")}),window.addEventListener("resize",this.resizeFooterToolbar,{passive:!0})}},{key:"componentWillUnmount",value:function(){window.removeEventListener("resize",this.resizeFooterToolbar)}},{key:"render",value:function(){this.state.width;return k.a.createElement(F["a"],{title:"\u6295\u7a3f",content:"\u8bf7\u6309\u7167\u6307\u793a\u63d0\u4ea4\u7a3f\u4ef6\u5185\u5bb9",wrapperClassName:ve.a.advancedForm},k.a.createElement(r["a"],{title:"\u6587\u7ae0\u57fa\u672c\u4fe1\u606f",bordered:!1,className:ve.a.card},k.a.createElement(E["a"],{layout:"vertical",hideRequiredMark:!0},k.a.createElement(l["a"],{gutter:16},k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u6587\u7ae0\u6807\u9898"},this.props.form.getFieldDecorator("title",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u6587\u7ae0\u6807\u9898"}]})(k.a.createElement(i["a"],{placeholder:"\u6587\u7ae0\u6807\u9898"})))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u5b66\u672f\u9886\u57df"},this.props.form.getFieldDecorator("academicsec",{initialValue:1,rules:[{required:!0,message:"\u8bf7\u9009\u62e9\u5b66\u672f\u9886\u57df"}]})(k.a.createElement(c["a"],null,this.generateAcademicSec())))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u680f\u76ee"},this.props.form.getFieldDecorator("column",{initialValue:1,rules:[{required:!0,message:"\u8bf7\u9009\u62e9\u680f\u76ee"}]})(k.a.createElement(c["a"],null,this.generateColumn()))))))),k.a.createElement(r["a"],{title:"\u5173\u952e\u8bcd",bordered:!1,className:ve.a.card},k.a.createElement(E["a"],{layout:"vertical"},k.a.createElement(l["a"],{gutter:16},k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u4e2d\u6587\u5173\u952e\u8bcd1"},this.props.form.getFieldDecorator("keyword1_cn",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u4e2d\u6587\u5173\u952e\u8bcd1"}]})(k.a.createElement(i["a"],{placeholder:"\u4e2d\u6587\u5173\u952e\u8bcd1"})))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u4e2d\u6587\u5173\u952e\u8bcd2"},this.props.form.getFieldDecorator("keyword2_cn")(k.a.createElement(i["a"],{placeholder:"\u4e2d\u6587\u5173\u952e\u8bcd2"})))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u4e2d\u6587\u5173\u952e\u8bcd3"},this.props.form.getFieldDecorator("keyword3_cn")(k.a.createElement(i["a"],{placeholder:"\u4e2d\u6587\u5173\u952e\u8bcd3"})))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u4e2d\u6587\u5173\u952e\u8bcd4"},this.props.form.getFieldDecorator("keyword4_cn")(k.a.createElement(i["a"],{placeholder:"\u4e2d\u6587\u5173\u952e\u8bcd4"}))))),k.a.createElement(l["a"],{gutter:16},k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u82f1\u6587\u5173\u952e\u8bcd1"},this.props.form.getFieldDecorator("keyword1_en",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u82f1\u6587\u5173\u952e\u8bcd1"}]})(k.a.createElement(i["a"],{placeholder:"\u82f1\u6587\u5173\u952e\u8bcd1"})))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u82f1\u6587\u5173\u952e\u8bcd2"},this.props.form.getFieldDecorator("keyword2_en")(k.a.createElement(i["a"],{placeholder:"\u82f1\u6587\u5173\u952e\u8bcd2"})))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u82f1\u6587\u5173\u952e\u8bcd3"},this.props.form.getFieldDecorator("keyword3_en")(k.a.createElement(i["a"],{placeholder:"\u82f1\u6587\u5173\u952e\u8bcd3"})))),k.a.createElement(o["a"],{lg:6,md:12,sm:24},k.a.createElement(E["a"].Item,{label:"\u82f1\u6587\u5173\u952e\u8bcd4"},this.props.form.getFieldDecorator("keyword4_en")(k.a.createElement(i["a"],{placeholder:"\u82f1\u6587\u5173\u952e\u8bcd4"}))))))),k.a.createElement(r["a"],{title:"\u6458\u8981",bordered:!1,className:ve.a.card},k.a.createElement(E["a"],{layout:"horizontal"},k.a.createElement(E["a"].Item,{label:"\u4e2d\u6587\u6458\u8981"},this.props.form.getFieldDecorator("summary_cn",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u4e2d\u6587\u6458\u8981"}]})(k.a.createElement(i["a"].TextArea,{rows:8,placeholder:"\u8bf7\u8f93\u5165\u4e2d\u6587\u6458\u8981"}))),k.a.createElement(E["a"].Item,{label:"\u82f1\u6587\u6458\u8981"},this.props.form.getFieldDecorator("summary_en",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u82f1\u6587\u6458\u8981"}]})(k.a.createElement(i["a"].TextArea,{rows:8,placeholder:"\u8bf7\u8f93\u5165\u82f1\u6587\u6458\u8981"}))))),k.a.createElement(r["a"],{title:"\u4f5c\u8005\u4fe1\u606f",bordered:!1,className:ve.a.card},k.a.createElement(E["a"].Item,null,this.props.form.getFieldDecorator("author",{initialValue:[],rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u4f5c\u8005\u4fe1\u606f"}]})(k.a.createElement(he,null)))),k.a.createElement(r["a"],{title:"\u63d0\u4ea4\u6587\u4ef6",bordered:!1,className:ve.a.card},k.a.createElement(E["a"],{layout:"inline"},k.a.createElement(E["a"].Item,{label:"\u63d0\u4ea4\u6587\u7ae0"},k.a.createElement(n["a"],{onClick:this.uploadFile1},"\u9009\u62e9\u6587\u4ef6")," ",k.a.createElement("br",null),this.state.filename1,k.a.createElement("input",{type:"file",id:"uploadFile1",name:"file1",onChange:this.onFileChange1,style:{display:"none"},ref:"uploadBox1"})),k.a.createElement(E["a"].Item,{label:"\u63d0\u4ea4\u9644\u4ef6"},k.a.createElement(n["a"],{onClick:this.uploadFile2},"\u9009\u62e9\u6587\u4ef6")," ",k.a.createElement("br",null),this.state.filename2,k.a.createElement("input",{type:"file",id:"uploadFile2",name:"file2",onChange:this.onFileChange2,style:{display:"none"},ref:"uploadBox2"})))),k.a.createElement(r["a"],{bordered:!1,className:ve.a.card},k.a.createElement(n["a"],{type:"primary",onClick:this.validate},"\u63d0\u4ea4")))}}]),t}(k.a.Component),re=le))||re)||re);t["default"]=we}}]);