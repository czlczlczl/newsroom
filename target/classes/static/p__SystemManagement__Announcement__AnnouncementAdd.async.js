(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[54],{T3Gb:function(e,t,n){"use strict";n.r(t);n("IzEo");var a,o,l,r,c=n("bx4M"),u=(n("+L6B"),n("2/Rp")),m=(n("5NDa"),n("5rEg")),p=(n("miYZ"),n("tsqr")),d=n("2Taf"),s=n.n(d),f=n("vZ4D"),h=n.n(f),v=n("l4Ni"),y=n.n(v),g=n("ujKo"),E=n.n(g),b=n("MhPg"),w=n.n(b),C=(n("y8nQ"),n("Vl3Y")),F=n("q1tI"),T=n.n(F),k=n("MuoO"),D=n("usdK"),I=n("GguQ"),S=n.n(I),M=n("zHco"),x="adminAddAnnouncement",j=function(e){var t=e[x].result;return{result:t}},q=(a=Object(k["connect"])(j,null),o=C["a"].create(),a(l=o((r=function(e){function t(e){var n;return s()(this,t),n=y()(this,E()(t).call(this,e)),n.pic=[],n.onFileChange=function(e){var t=e.target.files[0];n.setState({file:t,filename:t?t.name:null})},n.uploadFile=function(e){e.preventDefault(),n.refs.uploadBox.click()},n.initEditor=function(){var e=n.refs.editorElem,t=new S.a(e);n.editor=t,t.customConfig.uploadImgServer="/admin/uploadpic",t.customConfig.uploadImgMaxLength=1,t.customConfig.customUploadImg=function(e,t){if(e[0])if(e[0]){var a=new FormData;a.append("file",e[0]),fetch("/admin/uploadpic",{method:"POST",header:{"Content-Type":"multipart/form-data"},body:a}).then(function(e){return e.json()}).then(function(e){var a=e.result;a?(t("/static/pic/".concat(e.url)),n.pic.push(e.url)):p["a"].error("\u4e0a\u4f20\u9519\u8bef")})}else p["a"].info("\u8bf7\u9009\u62e9\u8981\u4e0a\u4f20\u7684\u56fe\u7247")},t.create()},n.onSubmit=function(e){e.preventDefault(),n.props.form.validateFields(function(e,t){if(!e){for(var a=new FormData,o="",l=0;l<n.pic.length-1;l++)o=o.concat(n.pic[l]).concat("|");o=o.concat(n.pic[i]),a.append("pic",o),a.append("file",n.state.file),a.append("title",n.values.title),a.append("content",n.editor.txt.html()),fetch("/admin/createannouncement",{method:"POST",header:{"Content-Type":"multipart/form-data"},body:a}).then(function(e){return e.json()}).then(function(e){if(1!=e.result)p["a"].error("\u65b0\u589e\u5931\u8d25");else{var a={title:t.title};n.props.dispatch({type:"".concat(x,"/modifyTitle"),payload:a,callback:function(){D["a"].push("/systemmanagement/announcement/result")}})}})}})},n.state={file:void 0,filename:void 0},n}return w()(t,e),h()(t,[{key:"componentDidMount",value:function(){this.initEditor()}},{key:"render",value:function(){return T.a.createElement(M["a"],{title:"\u65b0\u589e\u516c\u544a"},T.a.createElement(c["a"],{bordered:!1},T.a.createElement(C["a"],{layout:"vertical",style:{marginTop:8},onSubmit:this.onSubmit,hideRequiredMark:!0},T.a.createElement(C["a"].Item,{label:"\u516c\u544a\u6807\u9898"},this.props.form.getFieldDecorator("title",{rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u516c\u544a\u6807\u9898"}]})(T.a.createElement(m["a"],{placeholder:"\u8bf7\u8f93\u5165\u516c\u544a\u6807\u9898",style:{width:1e3}}))),T.a.createElement(C["a"].Item,{label:"\u516c\u544a\u6b63\u6587"},T.a.createElement("div",{ref:"editorElem"})),T.a.createElement(C["a"].Item,{label:"\u516c\u544a\u9644\u4ef6\uff08\u82e5\u8bbe\u5b9a\u5219\u66f4\u65b0\u539f\u6587\u4ef6\uff09"},T.a.createElement(u["a"],{onClick:this.uploadFile},"\u9009\u62e9\u9644\u4ef6")," ",T.a.createElement("br",null),this.state.filename,T.a.createElement("input",{type:"file",id:"uploadFile",name:"file",onChange:this.onFileChange,style:{display:"none"},ref:"uploadBox"})),T.a.createElement(u["a"],{type:"primary",htmlType:"submit",style:{float:"right"}},"\u63d0\u4ea4"))))}}]),t}(T.a.Component),l=r))||l)||l);t["default"]=q}}]);