(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[83],{"K+eA":function(e,a,t){"use strict";t.r(a);t("+L6B");var n,r,o,s=t("2/Rp"),l=t("jehZ"),i=t.n(l),c=(t("5NDa"),t("5rEg")),p=(t("OaEy"),t("2fM7")),u=t("2Taf"),d=t.n(u),m=t("vZ4D"),h=t.n(m),f=t("l4Ni"),g=t.n(f),E=t("ujKo"),w=t.n(E),k=t("MhPg"),y=t.n(k),L=(t("y8nQ"),t("Vl3Y")),v=t("q1tI"),b=t.n(v),q=t("MuoO"),I=t("usdK"),_=t("agfa"),C=t.n(_),M="registerStorage",D="locationInfo",O=function(e){var a=e[M],t=e[D].locationList;return{locationList:t,stateContent:a}},j={labelCol:{span:5},wrapperCol:{span:19}},F=(n=Object(q["connect"])(O,null),r=L["a"].create(),n(o=r(o=function(e){function a(){return d()(this,a),g()(this,w()(a).apply(this,arguments))}return y()(a,e),h()(a,[{key:"componentDidMount",value:function(){this.props.dispatch({type:"".concat(D,"/queryLocationList")})}},{key:"generateLocationList",value:function(){if(!this.props.locationList)return null;for(var e=[],a=0;a<this.props.locationList.length;a++)e.push(b.a.createElement(p["a"].Option,{value:this.props.locationList[a].id},this.props.locationList[a].location));return e}},{key:"render",value:function(){var e=this,a=this.props.form.getFieldDecorator,t=function(){e.props.form.validateFields(function(a,t){if(!a){var n={address:t.address,postcode:t.postcode,workspace_cn:t.workspace_cn,workspace_en:t.workspace_en,location:t.location};e.props.dispatch({type:"".concat(M,"/step2"),payload:n}),I["a"].push("/user/register/education")}})};return b.a.createElement(L["a"],{layout:"horizontal",className:C.a.stepForm,hideRequiredMark:!0},b.a.createElement(L["a"].Item,i()({},j,{label:"\u8054\u7cfb\u5730\u5740"}),a("address",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u8054\u7cfb\u5730\u5740"}]})(b.a.createElement(c["a"],{placeholder:"\u8bf7\u8f93\u5165\u8054\u7cfb\u5730\u5740"}))),b.a.createElement(L["a"].Item,i()({},j,{label:"\u90ae\u653f\u7f16\u7801"}),a("postcode",{rules:[{required:!0,pattern:new RegExp(/^[1-9]\d*$/,"g"),message:"\u8bf7\u8f93\u5165\u7b26\u5408\u89c4\u8303\u7684\u90ae\u653f\u7f16\u7801"},{len:6,message:"\u8bf7\u8f93\u5165\u7b26\u5408\u89c4\u8303\u7684\u90ae\u653f\u7f16\u7801"}]})(b.a.createElement(c["a"],{placeholder:"\u8bf7\u8f93\u5165\u90ae\u653f\u7f16\u7801"}))),b.a.createElement(L["a"].Item,i()({},j,{label:"\u5de5\u4f5c\u5355\u4f4d\uff08\u4e2d\u6587\uff09"}),a("workspace_cn",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u5de5\u4f5c\u5355\u4f4d\uff08\u4e2d\u6587\uff09"}]})(b.a.createElement(c["a"],{placeholder:"\u8bf7\u8f93\u5165\u5de5\u4f5c\u5355\u4f4d\uff08\u4e2d\u6587\uff09"}))),b.a.createElement(L["a"].Item,i()({},j,{label:"\u5de5\u4f5c\u5355\u4f4d\uff08\u82f1\u6587\uff09"}),a("workspace_en",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u5de5\u4f5c\u5355\u4f4d\uff08\u82f1\u6587\uff09"}]})(b.a.createElement(c["a"],{placeholder:"\u8bf7\u8f93\u5165\u5de5\u4f5c\u5355\u4f4d\uff08\u82f1\u6587\uff09"}))),b.a.createElement(L["a"].Item,i()({},j,{label:"\u5730\u70b9"}),a("location",{initialValue:1,rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u5730\u70b9\u4fe1\u606f"}]})(b.a.createElement(p["a"],null,this.generateLocationList()))),b.a.createElement(s["a"],{type:"primary",onClick:t},"\u63d0\u4ea4"))}}]),a}(b.a.Component))||o)||o);a["default"]=F}}]);