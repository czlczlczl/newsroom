(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[17],{xAzK:function(t,e,a){"use strict";a.r(e);var r,i,o,s=a("2Taf"),l=a.n(s),n=a("vZ4D"),p=a.n(n),c=a("l4Ni"),u=a.n(c),h=a("ujKo"),m=a.n(h),d=a("MhPg"),D=a.n(d),f=a("q1tI"),E=a.n(f),L=a("MuoO"),y=a("bmkC"),g=a("+kNj"),j=a("zHco"),v="adminAuthorDetail",S="locationInfo",w="majorInfo",k="educationInfo",A="academicSection",q=function(t){var e=t[v].data,a=t[v].loading,r=t[S].locationList,i=t[w].majorList,o=t[k].educationList,s=t[A].list;return{academicSec:s,authorDetail:e,educationList:o,locationList:r,loading:a,majorList:i}},z=(r=Object(L["connect"])(q,null),r((o=function(t){function e(){var t,a;l()(this,e);for(var r=arguments.length,i=new Array(r),o=0;o<r;o++)i[o]=arguments[o];return a=u()(this,(t=m()(e)).call.apply(t,[this].concat(i))),a.translateLocation=function(t){if(!a.props.locationList)return null;for(var e=0;e<a.props.locationList.length;e++)if(a.props.locationList[e].id==t)return a.props.locationList[e].location;return null},a.translateMajor=function(t){if(!a.props.majorList)return null;for(var e=0;e<a.props.majorList.length;e++)if(a.props.majorList[e].id==t)return a.props.majorList[e].major;return null},a.translateEducation=function(t){if(!a.props.educationList)return null;for(var e=0;e<a.props.educationList.length;e++)if(a.props.educationList[e].id==t)return a.props.educationList[e].education;return null},a.translateAcademicSec=function(t){if(!a.props.academicSec)return null;for(var e=0;e<a.props.academicSec.length;e++)if(a.props.academicSec[e].id==t)return a.props.academicSec[e].academicsec;return null},a}return D()(e,t),p()(e,[{key:"componentDidMount",value:function(){var t={username:this.props.match.params.username};this.props.dispatch({type:"".concat(v,"/queryAuthorDetail"),payload:t}),this.props.dispatch({type:"".concat(S,"/queryLocationList")}),this.props.dispatch({type:"".concat(k,"/queryEducationList")}),this.props.dispatch({type:"".concat(w,"/queryMajorList")}),this.props.dispatch({type:"".concat(A,"/queryList")})}},{key:"render",value:function(){var t=g["a"].Description;return E.a.createElement(j["a"],{title:"\u8bfb\u8005\u4fe1\u606f",loading:this.props.loading},E.a.createElement(y["Card"],{bordered:!1},E.a.createElement(g["a"],{size:"large",title:"\u57fa\u7840\u4fe1\u606f",style:{marginBottom:32}},E.a.createElement(t,{term:"\u5185\u90e8ID"},this.props.authorDetail?this.props.authorDetail.id:null),E.a.createElement(t,{term:"\u7528\u6237\u540d"},this.props.authorDetail?this.props.authorDetail.email:null),E.a.createElement(t,{term:"\u59d3\u540d"},this.props.authorDetail?this.props.authorDetail.name:null),E.a.createElement(t,{term:"\u59d3\u540d\uff08\u62fc\u97f3\uff09"},this.props.authorDetail?this.props.authorDetail.name_pinyin:null),E.a.createElement(t,{term:"\u6027\u522b"},this.props.authorDetail?1===this.props.authorDetail.gender?"\u7537":"\u5973":null),E.a.createElement(t,{term:"\u624b\u673a\u53f7"},this.props.authorDetail?this.props.authorDetail.phonenum:null),E.a.createElement(t,{term:"\u4e2a\u4eba\u4ecb\u7ecd"},this.props.authorDetail?this.props.authorDetail.introduction:null)),E.a.createElement(y["Divider"],{style:{marginBottom:32}}),E.a.createElement(g["a"],{size:"large",title:"\u5730\u5740\u4fe1\u606f",style:{marginBottom:32}},E.a.createElement(t,{term:"\u8054\u7cfb\u5730\u5740"},this.props.authorDetail?this.props.authorDetail.address:null),E.a.createElement(t,{term:"\u90ae\u653f\u7f16\u7801"},this.props.authorDetail?this.props.authorDetail.postcode:null),E.a.createElement(t,{term:"\u5de5\u4f5c\u5355\u4f4d\uff08\u4e2d\u6587\uff09"},this.props.authorDetail?this.props.authorDetail.workspace_cn:null),E.a.createElement(t,{term:"\u5de5\u4f5c\u5355\u4f4d\uff08\u82f1\u6587\uff09"},this.props.authorDetail?this.props.authorDetail.workspace_en:null),E.a.createElement(t,{term:"\u5730\u70b9"},this.props.authorDetail?this.translateLocation(this.props.authorDetail.location):null)),E.a.createElement(g["a"],{size:"large",title:"\u6559\u80b2\u4fe1\u606f",style:{marginBottom:32}},E.a.createElement(t,{term:"\u4e13\u4e1a\u4fe1\u606f"},this.props.authorDetail?this.translateMajor(this.props.authorDetail.major):null),E.a.createElement(t,{term:"\u6559\u80b2\u4fe1\u606f"},this.props.authorDetail?this.translateEducation(this.props.authorDetail.education):null),E.a.createElement(t,{term:"\u5934\u8854"},this.props.authorDetail?this.props.authorDetail.title:null),E.a.createElement(t,{term:"\u529e\u516c\u5ba4\u7535\u8bdd"},this.props.authorDetail?this.props.authorDetail.officetel:null)),E.a.createElement(g["a"],{size:"large",title:"\u5b66\u672f\u4fe1\u606f",style:{marginBottom:32}},E.a.createElement(t,{term:"\u7814\u7a76\u65b9\u5411"},this.props.authorDetail?this.props.authorDetail.researchdir:null),E.a.createElement(t,{term:"\u5b66\u672f\u5206\u533a1"},this.props.authorDetail?this.translateAcademicSec(this.props.authorDetail.academicsec1):null),E.a.createElement(t,{term:"\u5b66\u672f\u5206\u533a2"},this.props.authorDetail?this.props.authorDetail.academicsec2?this.translateAcademicSec(this.props.authorDetail.academicsec2):"\u65e0":null),E.a.createElement(t,{term:"\u5b66\u672f\u5206\u533a3"},this.props.authorDetail?this.props.authorDetail.academicsec3?this.translateAcademicSec(this.props.authorDetail.academicsec3):"\u65e0":null))))}}]),e}(E.a.Component),i=o))||i);e["default"]=z}}]);