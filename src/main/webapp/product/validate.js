var success = true;
$('#price').live('blur', function(event) {
	success = produceTimeVadFn();
	success = priceVadFn(event) && success;
	success ? $('.submit').show() : $('.submit').hide();
});
$('#produceTime').live('blur', function(event) {
	success = priceVadFn();
	success = produceTimeVadFn(event) && success;
	success ? $('.submit').show() : $('.submit').hide();
});
$('#produceTime').live('keyup', function(event) {
	success = priceVadFn();
	success = produceTimeVadFn(event) && success;
	success ? $('.submit').show() : $('.submit').hide();
});
function priceVadFn(event) {
	var value = $('#price').val();
	var valid = /^(\d+(\.\d*)?)?$/.test(value)
	$('#price').siblings(".errorMsg").html(valid ? "" : "价格格式错误，必须为一个数字");
	return valid
}
function produceTimeVadFn(event) {
	var value = $('#produceTime').val();
	var valid = /^(\d{4}-\d{2}-\d{2})?$/.test(value);
	$('#produceTime').siblings(".errorMsg").html(
			valid ? "" : "日期格式错误,例如：2013-01-01");
	success = valid && success;
	success ? $('.submit').show() : $('.submit').hide();
	if (event && (event.keyCode == 8 || event.keyCode == 46)) {//删除的时候不格式补全
		return;
	}
	if (/^\d{4}(-\d{2})?$/.test(value)) {
		$('#produceTime').val(value + "-")
	}
	return valid;
}
