<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_supprs" method="post">
	<table cellpadding="5">
		<tr>
			<td>客户名称：</td>
			<td>
				<input id="id_objid" class="easyui-textbox" type="text" name="objid" data-options="required:true"></input>
				<input id="id_staffobjid" class="easyui-textbox" type="hidden" name="staffobjid"></input>
			</td>
		</tr>
		<tr>
			<td>员工名称：</td>
			<td><input id="id_staffid" class="easyui-textbox" type="text" name="staffid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>关系类型：</td>
			<td><input id="id_cstype" class="easyui-textbox" type="text" name="cstype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>对象类型：</td>
			<td><input id="cbx_objtype" class="easyui-textbox" type="text" name="objtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建时间：</td>
			<td><input id="id_createtime" class="easyui-textbox" type="text" name="createtime" data-options="formatter:dateFormatter,parser:myparser,required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var objCombox = new BSS.Combox('#cbx_objtype');
objCombox.fromDict('DICT_OBJTYPE',function(){
	initSuppersEditPage();
});
$('#id_createtime').datebox({
    required:true
});
function dateFormatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+(m<10?('0'+m):m)+(d<10?('0'+d):d);
}
function myparser(s){
	s=''+s;
	if (!s) return new Date();
	var y = s.substring(0,4);
	var m =s.substring(4,6);
	var d = s.substring(6,8);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}
function initSuppersEditPage(){
	BSS.dispatch({code:13015,data:[{staffobjid:'${staffobjid}'}]},function(resp){
		if(resp.code == 0){
			BSS.json2form('#frm_supprs',resp.data[0]);
			
			SUPPRSDIALOG.ok = function(){
				var supprs = BSS.form2json('#frm_supprs');
				BSS.dispatch({code:13005,data:[supprs]},function(){
					BSS.alert('保存成功！');
				},function(){});
			};
		}else{
			SUPPRSDIALOG.ok = function(){};
			BSS.warning(resp.message);
		}
	});
}
</script>