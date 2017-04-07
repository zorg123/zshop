function openBlankWindow(url){
	var iForm = $("<form method=\"post\" action==\""+url+"\" target=\"_blank\"></form>");
	$(document.body).append(iForm);
    $(iForm).submit();
    $(iForm).remove();
}