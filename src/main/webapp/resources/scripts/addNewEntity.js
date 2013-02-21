$(document).ready(function() {
	$('#department').hide();
	$('#department-select').show();
	$('input.input-disable').each(function() {
		var input = $(this);
		input.toggleClass('input-disable input-enable'); 
	});
});
