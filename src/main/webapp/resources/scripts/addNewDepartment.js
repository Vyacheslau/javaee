$(document).ready(function() {
	$('.input-disable').each(function() {
		var input = $(this);
		input.toggleClass('input-disable input-enable'); 
	});
});
