(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[55],{Epac:function(e,t,n){"use strict";n.r(t);n("IzEo");var a,s,o,r,c=n("bx4M"),l=(n("14J3"),n("BMrR")),i=(n("+L6B"),n("2/Rp")),m=(n("jCWc"),n("kPKH")),u=(n("5NDa"),n("5rEg")),p=(n("miYZ"),n("tsqr")),d=n("p0pE"),g=n.n(d),h=n("2Taf"),f=n.n(h),y=n("vZ4D"),E=n.n(y),b=n("l4Ni"),v=n.n(b),w=n("ujKo"),L=n.n(w),R=n("MhPg"),k=n.n(R),D=(n("y8nQ"),n("Vl3Y")),F=(n("2qtc"),n("kLXV")),B=n("q1tI"),S=n.n(B),C=n("wd/R"),T=n.n(C),q=n("MuoO"),O=n("usdK"),x=n("CkN6"),A=n("zHco"),I=n("hDsc"),M=n.n(I),N="adminAnnouncementList",V=function(e){var t=e[N].pageBean,n=e[N].rows,a=e[N].loading;return{loading:a,pageBean:t,rows:n}},Y=function(e,t){var n=e.map(function(e){return e.title}),a=n.join(", ");F["a"].confirm({title:"\u662f\u5426\u786e\u8ba4\u5220\u9664\u4ee5\u4e0b\u516c\u544a",content:a,okText:"\u662f",okType:"danger",cancelText:"\u5426",onOk:function(){t(e)}})},P=(a=Object(q["connect"])(V,null),s=D["a"].create(),a(o=s((r=function(e){function t(e){var n;return f()(this,t),n=v()(this,L()(t).call(this,e)),n.handleSearch=function(e){e.preventDefault(),n.props.form.validateFields(function(e,t){if(!e){var a=g()({},t);n.setState({formValues:a});var s=g()({},a,{page:1});n.props.dispatch({type:"".concat(N,"/queryAnnouncementList"),payload:s})}})},n.handleFormReset=function(){n.props.form.resetFields(),n.setState({formValues:{}});var e={page:1};n.props.dispatch({type:"".concat(N,"/queryAnnouncementList"),payload:e})},n.handleDeleteRecordOneLine=function(e,t){Y([t],n.deleteFunc)},n.getTitleItem=function(e){O["a"].push("/systemmanagement/announcement/modify/".concat(e.id))},n.columns=[{title:"\u6807\u9898",dataIndex:"title",render:function(e,t){return S.a.createElement("a",{onClick:function(){return n.getTitleItem(t)}},t.title)}},{title:"\u53d1\u5e03\u65f6\u95f4",dataIndex:"date_pub",render:function(e){return T()(e).format("YYYY-MM-DD")}},{title:"\u64cd\u4f5c",render:function(e,t){return S.a.createElement(B["Fragment"],null,S.a.createElement("a",{onClick:function(){return n.handleDeleteRecordOneLine(!0,t)}},"\u5220\u9664"))}}],n.handleDeleteRecordLines=function(e){e.preventDefault(),Y(n.state.selectedRows,n.deleteFunc)},n.deleteFunc=function(e){new Promise(function(t,a){for(var s=function(t){var a={id:e[t].id},s=e[t];n.props.dispatch({type:"".concat(N,"/deleteAnnouncement"),payload:a,callback:function(e){1!=e.result&&p["a"].error("\u7a3f\u4ef6\u5220\u9664\u5931\u8d25\uff1a".concat(s.title))}})},o=0;o<e.length;o++)s(o);t()}).then(function(){var e={title:n.state.formValues.title,page:n.props.pageBean.currentPage};n.props.dispatch({type:"".concat(N,"/queryAnnouncementList"),payload:e})})},n.handleSelectRows=function(e){n.setState({selectedRows:e})},n.handleStandardTableChange=function(e,t,a){var s=n.props.dispatch,o=n.state.formValues,r=g()({page:e.current},o);s({type:"".concat(N,"/queryAnnouncementList"),payload:r})},n.state={selectedRows:[],formValues:{}},n}return k()(t,e),E()(t,[{key:"componentDidMount",value:function(){var e={page:1};this.props.dispatch({type:"".concat(N,"/queryAnnouncementList"),payload:e})}},{key:"renderForm",value:function(){var e=this.props.form.getFieldDecorator;return S.a.createElement(D["a"],{onSubmit:this.handleSearch,layout:"inline"},S.a.createElement(l["a"],{gutter:{md:8,lg:24,xl:48}},S.a.createElement(m["a"],{md:8,sm:24},S.a.createElement(D["a"].Item,{label:"\u516c\u544a\u6807\u9898"},e("title")(S.a.createElement(u["a"],{placeholder:"\u8bf7\u8f93\u5165\u516c\u544a\u6807\u9898"})))),S.a.createElement(m["a"],{md:8,sm:24},S.a.createElement("span",{className:M.a.submitButtons},S.a.createElement(i["a"],{type:"primary",htmlType:"submit"},"\u67e5\u8be2"),S.a.createElement(i["a"],{style:{marginLeft:8},onClick:this.handleFormReset},"\u6e05\u7a7a")))))}},{key:"render",value:function(){var e={list:this.props.rows,pagination:{total:this.props.pageBean?this.props.pageBean.total:0,pageSize:10,current:this.props.pageBean?this.props.pageBean.currentPage:1}};return S.a.createElement(A["a"],{title:"\u516c\u544a\u7ba1\u7406"},S.a.createElement(c["a"],{bordered:!1},S.a.createElement("div",{className:M.a.tableList},S.a.createElement("div",{className:M.a.tableListForm},this.renderForm()),S.a.createElement("div",{className:M.a.tableListOperator},S.a.createElement(i["a"],{icon:"plus",type:"primary",onClick:function(){return O["a"].push("/systemmanagement/announcement/add")}},"\u65b0\u589e\u516c\u544a"),this.state.selectedRows.length>0&&S.a.createElement("span",null,S.a.createElement(i["a"],{onClick:this.handleDeleteRecordLines},"\u6279\u91cf\u5220\u9664"))),S.a.createElement(x["a"],{selectedRows:this.state.selectedRows,loading:this.props.loading,data:e,columns:this.columns,onSelectRow:this.handleSelectRows,onChange:this.handleStandardTableChange}))))}}]),t}(S.a.Component),o=r))||o)||o);t["default"]=P},hDsc:function(e,t,n){e.exports={tableList:"antd-pro-pages-system-management-announcement-announcement-list-tableList",tableListOperator:"antd-pro-pages-system-management-announcement-announcement-list-tableListOperator",tableListForm:"antd-pro-pages-system-management-announcement-announcement-list-tableListForm",submitButtons:"antd-pro-pages-system-management-announcement-announcement-list-submitButtons",error:"antd-pro-pages-system-management-announcement-announcement-list-error",success:"antd-pro-pages-system-management-announcement-announcement-list-success",warning:"antd-pro-pages-system-management-announcement-announcement-list-warning","progress-pass":"antd-pro-pages-system-management-announcement-announcement-list-progress-pass",progress:"antd-pro-pages-system-management-announcement-announcement-list-progress"}}}]);