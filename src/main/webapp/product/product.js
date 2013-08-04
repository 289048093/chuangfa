var baseUrl = "productManager/product"
function deleteProduct(id) {
	if (!id) {
		alert('数据ID错误');
		return;
	}
	location = baseUrl + "!delete.action?cloudContext.vo.id=" + id;
}

function initUpdateProduct(id) {
	if (!id) {
		alert('数据ID错误');
		return;
	}
	location = baseUrl + "!init.action?cloudContext.vo.id=" + id;
}

function productDetail(id) {
	if (!id) {
		alert('数据ID错误');
		return;
	}
	location = baseUrl + "!productDetail.action?cloudContext.vo.id=" + id;
}

function typeProductList(id) {
	var $proDiv = $('#divType_' + id);
	if ($proDiv.css('display') != 'none') {
		$proDiv.hide();
	} else {
		$proDiv.show();
	}
}

function queryProduct(typeId) {
	var params = "";
	if (typeId) {
		params = "?cloudContext.params.typeId=" + typeId;
	}
	location = baseUrl + "!query.action" + params;
}