var baseUrl = "newsManager/news";

function deleteNews(id) {
	location = baseUrl + "!delete.action?cloudContext.vo.id=" + id;
}
function initUpdateNews(id){
	location = baseUrl + "!initUpdate.action?cloudContext.vo.id=" + id;
}