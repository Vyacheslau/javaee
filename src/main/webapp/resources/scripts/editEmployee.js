/*function enableEditing() {

	var edit = document.getElementById("edit");
	var save = document.getElementById("save");
	var cancel = document.getElementById("cancel");

	edit.className = "invisible";
	save.className = "visible";
	cancel.className = "visible";
}

function disableEditing() {
	var edit = document.getElementById("edit");
	var save = document.getElementById("save");
	var cancel = document.getElementById("cancel");

	edit.className = "visible";
	save.className = "invisible";
	cancel.className = "invisible";

}*/

$(document).ready(function() {
	$('input.input-disable').each(function() {
		$(this).attr('disabled', 'disabled');
		$("#edit-button").click(function() {
			$('input.input-disable').each(function() {
				$(this).removeAttr('disabled');
				$(this).removeClass('input-disable');
				$(this).addClass('input-enable');
				$(this).attr('data-remember', $(this).val());
			});
			
			document.getElementById("edit").className = "invisible";
			document.getElementById("save").className = "visible";
			document.getElementById("cancel").className = "visible";

			$('#cancel-button').click(function() {
				document.getElementById("edit").className = "visible";
				document.getElementById("save").className = "invisible";
				document.getElementById("cancel").className = "invisible";
				$('input.input-enable').each(function() {
					$(this).removeClass('input-enable');
					$(this).addClass('input-disable');
					$(this).attr('disabled', 'disabled');
					$(this).attr('border', '');
					$(this).val($(this).attr('data-remember'));
				});
			});
		});
	});
});
