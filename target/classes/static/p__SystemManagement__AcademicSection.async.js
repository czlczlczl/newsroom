(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[60],{"0Hqo":function(e,t,a){"use strict";a.r(t);a("IzEo");var s,i,n,r,d,o,c,l,p,u,h=a("bx4M"),m=(a("+L6B"),a("2/Rp")),f=(a("/zsF"),a("PArb")),g=a("jehZ"),b=a.n(g),y=(a("5NDa"),a("5rEg")),v=(a("OaEy"),a("2fM7")),V=a("2Taf"),S=a.n(V),L=a("vZ4D"),M=a.n(L),E=a("l4Ni"),w=a.n(E),A=a("ujKo"),R=a.n(A),C=a("MhPg"),k=a.n(C),O=(a("y8nQ"),a("Vl3Y")),D=(a("2qtc"),a("kLXV")),F=a("q1tI"),I=a.n(F),_=a("MuoO"),U=a("CkN6"),x=a("zHco"),q=a("2JR9"),B=a.n(q),T="adminAcademicSection",P=function(e){var t=e[T].pageBean,a=e[T].rows,s=e[T].loading;return{loading:s,pageBean:t,rows:a}},j=function(e,t){var a=e.map(function(e){return e.academicsec}),s=a.join(", ");D["a"].confirm({title:"\u662f\u5426\u786e\u8ba4\u5220\u9664\u4ee5\u4e0b\u5b66\u672f\u9886\u57df",content:s,okText:"\u662f",okType:"danger",cancelText:"\u5426",onOk:function(){t(e)}})},N={labelCol:{span:7},wrapperCol:{span:13}},J=(s=O["a"].create(),s((n=function(e){function t(e){var a;return S()(this,t),a=w()(this,R()(t).call(this,e)),a.handleAddModal=function(e){e.preventDefault();var t=a.props.handleAdd;a.props.form.validateFields(function(e,a){e||t({academicsec:a.academicsec,id_editor:a.id_editor})})},a.state={formVals:{academicsec:a.props.values.academicsec,id_editor:a.props.values.id_editor},editorList:void 0,visible:!1},a}return k()(t,e),M()(t,[{key:"renderEditorList",value:function(){if(!this.props.editorList)return null;for(var e=[],t=0;t<this.props.editorList.length;t++)e.push(I.a.createElement(v["a"].Option,{value:this.props.editorList[t].id},this.props.editorList[t].name));return e}},{key:"render",value:function(){var e=this;return this.props.isAddSuccess&&(this.setState({formVals:{},visible:!1}),this.props.handleChangeIsAddSuccess(!1)),I.a.createElement(D["a"],{width:640,bodyStyle:{padding:"32px 40px 48px"},destroyOnClose:!0,title:"\u6dfb\u52a0\u65b0\u5b66\u672f\u9886\u57df",visible:this.props.addModalVisible,onOk:this.handleAddModal,onCancel:function(){return e.props.handleAddModalVisible(!1,e.props.values)},afterClose:function(){e.props.handleAddModalVisible()}},I.a.createElement(O["a"].Item,b()({},N,{label:"\u5b66\u672f\u9886\u57df\u540d\u79f0"}),this.props.form.getFieldDecorator("academicsec",{initialValue:this.state.formVals.academicsec,rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u65b0\u7684\u5b66\u672f\u9886\u57df\u540d\u79f0"}]})(I.a.createElement(y["a"],{placeholder:"\u8bf7\u8f93\u5165\u65b0\u7684\u5b66\u672f\u9886\u57df\u540d\u79f0"}))),I.a.createElement(O["a"].Item,b()({},N,{label:"\u5904\u7406\u7684\u8d23\u4efb\u7f16\u8f91"}),this.props.form.getFieldDecorator("id_editor",{initialValue:this.state.formVals.id_editor,rules:[{required:!0,message:"\u8bf7\u9009\u62e9\u8d23\u4efb\u7f16\u8f91"}]})(I.a.createElement(v["a"],null,this.renderEditorList()))))}}]),t}(I.a.Component),i=n))||i),z=(r=O["a"].create(),r((o=function(e){function t(e){var a;return S()(this,t),a=w()(this,R()(t).call(this,e)),a.handleUpdateModal=function(e){e.preventDefault();var t=a.props,s=(t.form,t.handleUpdate);a.props.form.validateFields(function(e,t){e||s({id:a.props.record.id,academicsec:t.academicsec,id_editor:t.id_editor})})},a.state={formVals:{id:a.props.record?a.props.record.id:0,academicsec:a.props.record?a.props.record.academicsec:"",id_editor:a.props.record?a.props.record.id_editor:""}},a}return k()(t,e),M()(t,[{key:"renderEditorList",value:function(){if(!this.props.editorList)return null;for(var e=[],t=0;t<this.props.editorList.length;t++)e.push(I.a.createElement(v["a"].Option,{value:this.props.editorList[t].id},this.props.editorList[t].name));return e}},{key:"render",value:function(){var e=this;return I.a.createElement(D["a"],{width:640,bodyStyle:{padding:"32px 40px 48px"},destroyOnClose:!0,title:"\u4fee\u6539\u5b66\u672f\u9886\u57df",onOk:this.handleUpdateModal,visible:this.props.updateModalVisible,onCancel:function(){e.props.handleUpdateModalVisible()}},I.a.createElement(O["a"].Item,b()({},N,{label:"\u5185\u90e8ID"}),this.props.record.id),I.a.createElement(O["a"].Item,b()({},N,{label:"\u5b66\u672f\u9886\u57df\u540d\u79f0"}),this.props.form.getFieldDecorator("academicsec",{initialValue:this.props.record.academicsec,rules:[{required:!0,message:"\u8bf7\u8f93\u5165\u65b0\u7684\u5b66\u672f\u9886\u57df\u540d\u79f0"}]})(I.a.createElement(y["a"],{placeholder:"\u8bf7\u8f93\u5165\u65b0\u7684\u5b66\u672f\u9886\u57df\u540d\u79f0"}))),I.a.createElement(O["a"].Item,b()({},N,{label:"\u5904\u7406\u7684\u8d23\u4efb\u7f16\u8f91"}),this.props.form.getFieldDecorator("id_editor",{initialValue:this.props.record.id_editor,rules:[{required:!0,message:"\u8bf7\u9009\u62e9\u8d23\u4efb\u7f16\u8f91"}]})(I.a.createElement(v["a"],null,this.renderEditorList()))))}}]),t}(I.a.Component),d=o))||d),H=(c=Object(_["connect"])(P,null),l=O["a"].create(),c(p=l((u=function(e){function t(e){var a;return S()(this,t),a=w()(this,R()(t).call(this,e)),a.handleUpdateOneRecord=function(e,t){a.setState({updateModalVisible:!!e,updateRecord:t||{}})},a.columns=[{title:"\u5185\u90e8ID",dataIndex:"id"},{title:"\u5b66\u672f\u9886\u57df",dataIndex:"academicsec"},{title:"\u64cd\u4f5c",render:function(e,t){return I.a.createElement(F["Fragment"],null,I.a.createElement("a",{onClick:function(){return a.handleUpdateOneRecord(!0,t)}},"\u4fee\u6539"),I.a.createElement(f["a"],{type:"vertical"}),I.a.createElement("a",{onClick:function(){return a.handleDeleteRecordOneLine(!0,t)}},"\u5220\u9664"))}}],a.handleAddModalVisible=function(e,t){a.setState({addModalVisible:!!e,stepFormValues:t||{}})},a.handleUpdateModalVisible=function(e,t){a.setState({updateModalVisible:!!e,updateRecord:t||{}})},a.deleteFunc=function(e){new Promise(function(t,s){for(var i=function(t){var s={id:e[t].id},i=e[t];a.props.dispatch({type:"".concat(T,"/deleteOneSec"),payload:s,callback:function(e){1!=e.result&&message.error("\u6761\u76ee\u5220\u9664\u5931\u8d25\uff1a".concat(i.academicsec))}})},n=0;n<e.length;n++)i(n);t()}).then(function(){var e={page:a.props.pageBean.currentPage};a.props.dispatch({type:"".concat(T,"/querySec"),payload:e})})},a.handleDeleteRecordOneLine=function(e,t){a.setState({oneLineDeleteModalVisible:!!e,oneLineRecordValue:t||{}}),j([t],a.deleteFunc)},a.handleDeleteRecordLines=function(e){e.preventDefault(),j(a.state.selectedRows,a.deleteFunc)},a.handleModalVisible=function(e){a.setState({modalVisible:!!e})},a.handleSelectRows=function(e){a.setState({selectedRows:e})},a.handleChangeIsAddSuccess=function(e){a.setState({isAddSuccess:e})},a.handleAdd=function(e){var t=!1,s={academicsec:e.academicsec,id_editor:e.id_editor};return a.props.dispatch({type:"".concat(T,"/addSec"),payload:s,callback:function(e){if(1!=e.result)message.error("\u6dfb\u52a0\u9519\u8bef");else{message.success("\u6dfb\u52a0\u6210\u529f"),a.handleAddModalVisible(),a.handleChangeIsAddSuccess(!0);var t={page:a.props.pageBean.currentPage};a.props.dispatch({type:"".concat(T,"/querySec"),payload:t})}}}),t},a.handleStandardTableChange=function(e,t,s){var i=a.props.dispatch,n={page:e.current};i({type:"".concat(T,"/querySec"),payload:n})},a.handleUpdate=function(e){var t=!1,s={id:e.id,academicsec:e.academicsec,id_editor:e.id_editor};return a.props.dispatch({type:"".concat(T,"/updateSec"),payload:s,callback:function(e){if(1!=e.result)message.error("\u66f4\u65b0\u9519\u8bef");else{message.success("\u66f4\u65b0\u6210\u529f"),a.handleUpdateModalVisible();var t={page:a.props.pageBean.currentPage};a.props.dispatch({type:"".concat(T,"/querySec"),payload:t})}}}),t},a.state={modalVisible:!1,addModalVisible:!1,expandForm:!1,selectedRows:[],formValues:{},stepFormValues:{},updateModalVisible:!1,updateRecord:{},isAddSuccess:!1,oneLineDeleteModalVisible:{},oneLineRecordValue:{},editorList:void 0},a}return k()(t,e),M()(t,[{key:"componentDidMount",value:function(){var e=this,t={page:1};this.props.dispatch({type:"".concat(T,"/querySec"),payload:t});var a={func:"editor"};fetch("/contribute/resource",{method:"POST",credentials:"include",headers:{"Content-Type":"application/json;charset=UTF-8"},body:JSON.stringify(a)}).then(function(e){return e.json()}).then(function(t){e.setState({editorList:t})})}},{key:"render",value:function(){var e=this,t={list:this.props.rows,pagination:{total:this.props.pageBean?this.props.pageBean.total:0,pageSize:10,current:this.props.pageBean?this.props.pageBean.currentPage:1}},a={handleAddModalVisible:this.handleAddModalVisible,handleAdd:this.handleAdd},s={handleUpdateModalVisible:this.handleUpdateModalVisible,handleUpdate:this.handleUpdate},i=this.props.loading;return I.a.createElement(x["a"],{title:"\u5b66\u672f\u9886\u57df\u7ba1\u7406"},I.a.createElement(h["a"],{bordered:!1},I.a.createElement("div",{className:B.a.tableList},I.a.createElement("div",{className:B.a.tableListOperator},I.a.createElement(m["a"],{icon:"plus",type:"primary",onClick:function(){return e.handleAddModalVisible(!0)}},"\u65b0\u589e"),this.state.selectedRows.length>0&&I.a.createElement("span",null,I.a.createElement(m["a"],{onClick:this.handleDeleteRecordLines},"\u6279\u91cf\u5220\u9664"))),I.a.createElement(U["a"],{selectedRows:this.state.selectedRows,loading:i,data:t,columns:this.columns,onSelectRow:this.handleSelectRows,onChange:this.handleStandardTableChange,useSelectionRow:!0}))),I.a.createElement(J,b()({},a,{addModalVisible:this.state.addModalVisible,values:this.state.stepFormValues,isAddSuccess:this.state.isAddSuccess,handleChangeIsAddSuccess:this.handleChangeIsAddSuccess,editorList:this.state.editorList})),I.a.createElement(z,b()({},s,{updateModalVisible:this.state.updateModalVisible,record:this.state.updateRecord,editorList:this.state.editorList})))}}]),t}(I.a.Component),p=u))||p)||p);t["default"]=H},"2JR9":function(e,t,a){e.exports={tableList:"antd-pro-pages-system-management-academic-section-tableList",tableListOperator:"antd-pro-pages-system-management-academic-section-tableListOperator",tableListForm:"antd-pro-pages-system-management-academic-section-tableListForm",submitButtons:"antd-pro-pages-system-management-academic-section-submitButtons",error:"antd-pro-pages-system-management-academic-section-error",success:"antd-pro-pages-system-management-academic-section-success",warning:"antd-pro-pages-system-management-academic-section-warning","progress-pass":"antd-pro-pages-system-management-academic-section-progress-pass",progress:"antd-pro-pages-system-management-academic-section-progress"}}}]);