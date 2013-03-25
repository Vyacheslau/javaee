$(document).ready(function() {
	$('#manager').hide();
	$('#manager-select').show();
	$('.input-disable').each(function() {
		var input = $(this);
		input.toggleClass('input-disable input-enable'); 	
	});
});
