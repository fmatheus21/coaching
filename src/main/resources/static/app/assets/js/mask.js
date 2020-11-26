$(document).ready(function() {
	
	$('.mask-date').mask('00/00/0000');
	
	$('.mask-time').mask('00:00:00');
	
	$('.mask-date-time').mask('00/00/0000 00:00:00');
	
	$('.mask-cep').mask('00000-000');
	
	$('.mask-phone').mask('(00) 0000-0000');
	
	$('.mask-phone-with-ddd').mask('(00) 0000-0000');
	
	$('.mask-phone-us').mask('(000) 000-0000');
	
	$('.mask-mixed').mask('AAA 000-S0S');
	
	$('.mask-cpf').mask('000.000.000-00', {
		reverse : true
	});
	
	$('.mask-cnpj').mask('00.000.000/0000-00', {
		reverse : true
	});
	
	$('.mask-money').mask('000.000.000.000.000,00', {
		reverse : true
	});
	
	$('.mask-money2').mask("#.##0,00", {
		reverse : true
	});
	
	$('.mask-ip-address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
		translation : {
			'Z' : {
				pattern : /[0-9]/,
				optional : true
			}
		}
	});
	
	$('.mask-ip-address').mask('099.099.099.099');

	$('.mask-percent').mask('S999,99', {		
		reverse : true,
		translation: {'S': {pattern: /-/, optional: true}}
	});	
	
	$('.mask-clear-if-not-match').mask("00/00/0000", {
		clearIfNotMatch : true
	});
	
	$('.mask-placeholder').mask("00/00/0000", {
		placeholder : "__/__/____"
	});
	
	$('.mask-fallback').mask("00r00r0000", {
		translation : {
			'r' : {
				pattern : /[\/]/,
				fallback : '/'
			},
			placeholder : "__/__/____"
		}
	});
	
	$('.mask-selectonfocus').mask("00/00/0000", {
		selectOnFocus : true
	});
	
});




$(function() {
	$(".mask-money").maskMoney({
		symbol : '',
		precision : 2,
		showSymbol : true,
		thousands : '.',
		decimal : ',',
		symbolStay : true
	});
});

$(function() {
	$(".mask-weight").maskMoney({
		symbol : '',
		precision : 4,
		showSymbol : true,
		thousands : '.',
		decimal : ',',
		symbolStay : true
	});
});

$(function() {
	$(".mask-money2").maskMoney({
		symbol : '',
		precision : 3,
		showSymbol : true,
		thousands : '.',
		decimal : ',',
		symbolStay : true
	});
});

var KTInputmask = function() {

	var mask = function() {

		/*
		 * $(".mask-percentual").inputmask('mask', { "mask" : "99", 'alias' :
		 * 'numeric', 'placeholder' : '' });
		 */

		$(".mask-date").inputmask("99/99/9999", {
			"placeholder" : "dd/mm/yyyy",
			autoUnmask : true
		});

		$(".mask-year").inputmask("9999", {
			"placeholder" : "",
			autoUnmask : true
		});

		// mascara monetaria
		$(".currency").inputmask('decimal', {
			'alias' : 'numeric',
			'groupSeparator' : '.',
			'autoGroup' : true,
			'digits' : 2,
			'radixPoint' : ",",
			'digitsOptional' : false,
			'allowMinus' : false,
			'prefix' : 'R$ ',
			'placeholder' : ''
		});

		// mascara numero
		$(".mask-number").inputmask('decimal', {
			'alias' : 'numeric',
			'groupSeparator' : '.',
			'autoGroup' : true,
			'digits' : 0,
			'radixPoint' : ",",
			'digitsOptional' : true,
			'allowMinus' : false,
			'placeholder' : ''
		});
		// ip address
		$("#kt_inputmask_8").inputmask({
			"mask" : "999.999.999.999"
		});

		// email address
		$("#kt_inputmask_9")
				.inputmask(
						{
							mask : "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@*{1,20}[.*{2,6}][.*{1,2}]",
							greedy : false,
							onBeforePaste : function(pastedValue, opts) {
								pastedValue = pastedValue.toLowerCase();
								return pastedValue.replace("mailto:", "");
							},
							definitions : {
								'*' : {
									validator : "[0-9A-Za-z!#$%&'*+/=?^_`{|}~\-]",
									cardinality : 1,
									casing : "lower"
								}
							}
						});

		// mask mobile number
		$(".mask-mobile").inputmask("mask", {
			"mask" : "(99) 99999-9999"
		});

		// mask phone number
		$(".mask-phone").inputmask("mask", {
			"mask" : "(99) 9999-9999"
		});

		// mask cpf
		$(".mask-cpf").inputmask("mask", {
			"mask" : "999.999.999-99"
		});

		// mask cnpj
		$(".mask-cnpj").inputmask("mask", {
			"mask" : "99.999.999/9999-99"
		});

		// mask dia
		$(".mask-day").inputmask("99", {});

		// mask date
		$(".mask-date").inputmask("99/99/9999", {
			"placeholder" : "dd/mm/aaaa",
		});

		// mascara ano
		$(".mask-ano").inputmask("9999", {
			"placeholder" : "____",
		});

		// mask cep
		$(".mask-cep").inputmask("mask", {
			"mask" : "99.999-999"
		});

		// mask dinheiro
		$(".mask-dinheiro").inputmask("mask", {
			"mask" : "#.##0,00"
		});

		// mask email
		$(".mask-email")
				.inputmask(
						{
							mask : "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@*{1,20}[.*{2,6}][.*{1,2}]",
							greedy : false,
							onBeforePaste : function(pastedValue, opts) {
								pastedValue = pastedValue.toLowerCase();
								return pastedValue.replace("mailto:", "");
							},
							definitions : {
								'*' : {
									validator : "[0-9A-Za-z!#$%&'*+/=?^_`{|}~\-]",
									cardinality : 1,
									casing : "lower"
								}
							}
						});

	};

	return {
		// public functions
		init : function() {
			mask();
		}
	};

}();

function somenteNumeros(e) {
	var charCode = e.charCode ? e.charCode : e.keyCode;
	// charCode 8 = backspace
	// charCode 9 = tab
	if (charCode !== 8 && charCode !== 9) {
		// charCode 48 equivale a 0
		// charCode 57 equivale a 9
		if (charCode < 48 || charCode > 57) {
			return false;
		}
	}
}

jQuery(document).ready(function() {
	KTInputmask.init();

});
