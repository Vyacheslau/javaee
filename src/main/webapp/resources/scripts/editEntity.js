$(document).ready(function() {
	$('input.input-disable').each(function() {
		$(this).attr('disabled', 'disabled');
		$("#edit-button").click(function() {
			$('input.input-disable').each(function() {
				var input = $(this);
				input.removeAttr('disabled');
				input.toggleClass('input-disable input-enable');
				input.attr('data-remember', input.val());
			});
			
			$('#department').hide();
			$('#department-select').show();
						
			$('#edit').hide();
			$('#save').show();
			$('#cancel').show();

			$('#cancel-button').click(function() {
				$('#edit').show();
				$('#save').hide();
				$('#cancel').hide();

				$('input.input-enable').each(function() {
					var input = $(this);
					input.toggleClass('input-enable input-disable');
					input.attr('disabled', 'disabled');
					input.attr('border', '');
					input.val(input.attr('data-remember'));
				});
				
				$('#department').show();
				$('#department-select').hide();
			});
		});
	});
});
