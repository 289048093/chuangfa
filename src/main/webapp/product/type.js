var baseUrl = "typeManager/type";
function initInsertType() {
	var $insertTr = $("#insertTypeTr");
	if ($insertTr[0] != null) {
		return;
	}
	var $noRecordTr = $('#noRecordTr');
	if ($noRecordTr[0]) {
		$noRecordTr.hide();
	}
	$('#typeTabBody')
			.append(
					'<tr id="insertTypeTr"><td ></td><td><input type="text" id="insertInput"></td><td><a style="display:none;"  authUrl="deleteType" href="javascript:insertType();"><font color="red">确定添加</font> </a></td></tr>')
}

function insertType() {
	var $typeForm = $('#typeManagerForm');
	$typeForm.attr('action', baseUrl + "!insert.action");
	$('#typeNameInput').val($('#insertInput').val());
	$typeForm.submit();
}

function deleteType(id) {
	location = baseUrl + "!delete.action?cloudContext.vo.id=" + id
}
function initUpdateType(id) {
	var $updateInput = $('#updateInput');
	if ($updateInput[0]) {
		var oldId = $updateInput.next('input').val();
		cancelUpdate(oldId);
	}
	var name = $('#typeNameDiv_' + id).html();
	$('#typeNameInput_' + id).html(
			'<input type="text" id="updateInput" value="' + $.trim(name)
					+ '"/><input type="hidden" value="' + id + '"/>');
	$('#originalOperateType_' + id).hide();
	$('#operateConfirm_' + id).show();
	$('#typeNameDiv_' + id).hide();
	$('#typeNameInput_' + id).show();
}

function confirmUpdate(id) {
	var $typeForm = $('#typeManagerForm');
	$('#typeIdInput').val(id);
	$('#typeNameInput').val($('#updateInput').val());
	$typeForm.attr('action', baseUrl + "!update.action");
	$typeForm.submit();
}

function cancelUpdate(id) {
	$('#originalOperateType_' + id).show();
	$('#operateConfirm_' + id).hide();
	$('#typeNameDiv_' + id).show();
	$('#typeNameInput_' + id).remove();
}