(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[90],{L7Zt:function(e,a,t){"use strict";t.r(a);t("+L6B");var r,s,n,l,o=t("2/Rp"),c=(t("7Kak"),t("9yH6")),i=(t("Q9mQ"),t("diRs")),m=t("jehZ"),p=t.n(m),u=(t("5NDa"),t("5rEg")),d=(t("miYZ"),t("tsqr")),h=(t("MXD1"),t("CFYs")),g=t("2Taf"),v=t.n(g),f=t("vZ4D"),E=t.n(f),w=t("l4Ni"),y=t.n(w),x=t("ujKo"),b=t.n(x),N=t("MhPg"),T=t.n(N),k=(t("y8nQ"),t("Vl3Y")),I=t("q1tI"),F=t.n(I),C=t("MuoO"),P=t("usdK"),S=t("mOP9"),q=t("ixbx"),D=t("agfa"),L=t.n(D),M="registerStorage",O="isMailExist",Z=function(e){var a=e[M];return{stateContent:a}},R={labelCol:{span:5},wrapperCol:{span:19}},V={good:F.a.createElement("div",{className:L.a.success},"\u5f3a\u5ea6\uff1a\u5f3a"),ok:F.a.createElement("div",{className:L.a.warning},"\u5f3a\u5ea6\uff1a\u4e2d"),poor:F.a.createElement("div",{className:L.a.error},"\u5f3a\u5ea6\uff1a\u5f31")},j={good:"success",ok:"normal",poor:"exception"},K=(r=Object(C["connect"])(Z,null),s=k["a"].create(),r(n=s((l=function(e){function a(e){var t;return v()(this,a),t=y()(this,b()(a).call(this,e)),t.getPasswordStrengthLevel=function(){var e=t.props.form.getFieldValue("password"),a=/^\w*[A-Z]+\w*/,r=/^\w+/;return e&&e.length>15&&a.test(e)?"good":e&&e.length>=10&&r.test(e)?"ok":"poor"},t.checkPassword=function(e,a,r){if(a?t.setState({visible:!!a}):(t.setState({help:"\u8bf7\u8f93\u5165\u65b0\u7684\u5bc6\u7801",visible:!!a}),r("\u8bf7\u8f93\u5165\u5bc6\u7801")),a.length<10)r("\u5bc6\u7801\u957f\u5ea6\u8bf7\u5927\u4e8e\u7b49\u4e8e10\u4f4d");else{var s=t.props.form;a&&t.state.confirmDirty&&s.validateFields(["confirm"],{force:!0}),r()}},t.getProgressPercent=function(e){var a=j[t.getPasswordStrengthLevel()];return"exception"==a?20:"normal"==a?60:"success"==a?100:0},t.renderPasswordStrength=function(){var e=t.props.form,a=e.getFieldValue("password"),r=t.getPasswordStrengthLevel();return a&&a.length?F.a.createElement("div",{className:L.a["progress-".concat(r)]},F.a.createElement(h["a"],{status:j[r],className:L.a.progress,strokeWidth:6,percent:t.getProgressPercent(a),showInfo:!1})):null},t.checkConfirm=function(e,a,r){a&&a!==t.props.form.getFieldValue("password")?r("\u4e24\u6b21\u8f93\u5165\u7684\u5bc6\u7801\u4e0d\u4e00\u81f4"):r()},t.captchaInputOnChange=function(e){e.preventDefault(),t.setState({captchaInput:e.target.value})},t.getCaptchaText=function(e){var a=e;t.setState({captchaText:a})},t.state={confirmDirty:!1,visible:!1,help:"",captchaText:"",captchaInput:""},t}return T()(a,e),E()(a,[{key:"componentDidMount",value:function(){this.props.dispatch({type:"".concat(M,"/resetState")})}},{key:"render",value:function(){var e=this,a=this.props.form,t=a.getFieldDecorator,r=a.validateFields,s=function(){r(function(a,t){if(!a){if(e.state.captchaText!=e.state.captchaInput)return void d["a"].error("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u9a8c\u8bc1\u7801");var r={email:t.email};e.props.dispatch({type:"".concat(O,"/queryIsExist"),payload:r,callback:function(a){if(1!=a.isExist){var r={email:t.email,password:t.password,name:t.name,name_pinyin:t.name_pinyin,gender:t.gender,phonenum:t.phonenum,introduction:t.introduction};e.props.dispatch({type:"".concat(M,"/step1"),payload:r}),P["a"].push("/user/register/address")}else d["a"].error("\u60a8\u8f93\u5165\u7684\u90ae\u7bb1\u5df2\u5b58\u5728")}})}})};return F.a.createElement(k["a"],{layout:"horizontal",className:L.a.stepForm,hideRequiredMark:!0},F.a.createElement(k["a"].Item,p()({},R,{label:"\u5bc6\u4fdd\u90ae\u7bb1\uff1a"}),t("email",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u5bc6\u4fdd\u90ae\u7bb1\u5730\u5740"},{type:"email",message:"\u8bf7\u8f93\u5165\u6b63\u786e\u683c\u5f0f\u7684\u90ae\u7bb1"}]})(F.a.createElement(u["a"],{placeholder:"\u8bf7\u8f93\u5165\u5bc6\u4fdd\u90ae\u7bb1\u5730\u5740"}))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u5bc6\u7801"}),F.a.createElement(i["a"],{getPopupContainer:function(e){return e.parentNode},content:F.a.createElement("div",{style:{padding:"4px 0"}},V[this.getPasswordStrengthLevel()],this.renderPasswordStrength(),F.a.createElement("div",{style:{marginTop:10}},"\u8bf7\u8f93\u5165\u81f3\u5c1110\u4e2a\u5b57\u7b26\u7684\u5bc6\u7801\uff0c\u5305\u62ec\u5b57\u6bcd\u548c\u6570\u5b57\uff0c\u5efa\u8bae\u5305\u542b\u5927\u5199\u5b57\u6bcd\u3002")),overlayStyle:{width:240},placement:"right",visible:this.state.visible},t("password",{rules:[{validator:this.checkPassword}]})(F.a.createElement(u["a"],{type:"password",placeholder:"\u8bf7\u8f93\u5165\u5bc6\u7801"})))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u91cd\u590d\u8f93\u5165\u5bc6\u7801"}),t("confirm",{rules:[{required:!0,message:"\u9700\u8981\u518d\u8f93\u5165\u4e00\u6b21\u5bc6\u7801"},{validator:this.checkConfirm}]})(F.a.createElement(u["a"],{type:"password",placeholder:"\u8bf7\u8f93\u5165\u786e\u8ba4\u5bc6\u7801"}))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u59d3\u540d"}),t("name",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u59d3\u540d"}]})(F.a.createElement(u["a"],{placeholder:"\u8bf7\u8f93\u5165\u59d3\u540d"}))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u59d3\u540d\uff08\u62fc\u97f3\uff09"}),t("name_pinyin",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u59d3\u540d\u7684\u62fc\u97f3"}]})(F.a.createElement(u["a"],{placeholder:"\u8bf7\u8f93\u5165\u59d3\u540d\uff08\u62fc\u97f3\uff09"}))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u6027\u522b"}),t("gender",{rules:[{required:!0,message:"\u8bf7\u9009\u62e9\u6027\u522b"}]})(F.a.createElement(c["a"].Group,null,F.a.createElement(c["a"],{value:1},"\u7537"),F.a.createElement(c["a"],{value:2},"\u5973")))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u624b\u673a"}),t("phonenum",{rules:[{required:!0,pattern:new RegExp(/^[1-9]\d*$/,"g"),message:"\u8bf7\u8f93\u5165\u7b26\u5408\u89c4\u8303\u7684\u624b\u673a\u53f7"},{len:11,message:"\u8bf7\u8f93\u5165\u7b26\u5408\u89c4\u8303\u7684\u624b\u673a\u53f7"}]})(F.a.createElement(u["a"],{placeholder:"\u8bf7\u8f93\u5165\u624b\u673a\u53f7"}))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u4ecb\u7ecd"}),t("introduction",{rules:[{required:!0,message:"\u8bf7\u586b\u5199\u4ecb\u7ecd\u4fe1\u606f"},{max:300,message:"\u8bf7\u63a7\u5236\u5728300\u4e2a\u5b57\u7b26\u4ee5\u5185"}]})(F.a.createElement(u["a"].TextArea,{row:4,placeholder:"\u8bf7\u586b\u5199\u4ecb\u7ecd\u4fe1\u606f"}))),F.a.createElement(k["a"].Item,p()({},R,{className:L.a.stepFormText,label:"\u9a8c\u8bc1\u7801"}),F.a.createElement(u["a"],{placeholder:"\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801",onChange:this.captchaInputOnChange}),F.a.createElement(q["a"],{getCaptchaText:this.getCaptchaText,style:{marginTop:16}})),F.a.createElement(o["a"],{type:"primary",onClick:s},"\u63d0\u4ea4"),F.a.createElement(S["a"],{to:"/user/login",className:L.a.link},"\u5df2\u6709\u8d26\u53f7\uff1f"))}}]),a}(F.a.Component),n=l))||n)||n);a["default"]=K}}]);