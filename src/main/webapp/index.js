var baseProductUrl = "productManager/product"
function deleteProduct(id) {
	location = baseProductUrl + "!delete.action?cloudContext.vo.id=" + id;
}

function initUpdateProduct(id) {
	location = baseProductUrl + "!init.action?cloudContext.vo.id=" + id;
}

function productDetail(id) {
	location = baseProductUrl + "!productDetail.action?cloudContext.vo.id=" + id;
}

var baseNewsUrl = "newsManager/news";

function deleteNews(id) {
	location = baseNewsUrl + "!delete.action?cloudContext.vo.id=" + id;
}
function initUpdateNews(id){
	location = baseNewsUrl + "!initUpdate.action?cloudContext.vo.id=" + id;
}