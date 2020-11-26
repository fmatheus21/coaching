/* global FormValidation, KTUtil, KTApp, Swal */

// Class definition
var KTFormControls = function () {
    // Private functions



    /* form-coache-add */
    var initCoacheAdd = function (element) {
        FormValidation.formValidation(document.getElementById(element), {
            fields: {

                nome: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 3,
                            max: 100,
                            message: 'Deve conter no mínimo 3 e no máximo 100 caracteres'
                        }
                    }
                },
                nomeCasual: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 2,
                            max: 20,
                            message: 'Deve conter no mínimo 2 e no máximo 20 caracteres'
                        }
                    }
                },
                cpf: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        }
                    }
                },
                idSexo: {
                    validators: {
                        greaterThan: {
                            message: 'Preenchimento obrigatório.',
                            min: 1
                        }
                    }
                },
                dataNascimento: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        date: {
                            format: 'DD/MM/YYYY',
                            message: 'Informe uma data válida.'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        emailAddress: {
                            message: 'Informe um email válido.'
                        }
                    }
                },
                telefone: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        }
                    }
                }


            },
            plugins: {
                trigger: new FormValidation.plugins.Trigger,
                bootstrap: new FormValidation.plugins.Bootstrap,

                // Valide campos ao clicar no botão Enviar
                submitButton: new FormValidation.plugins.SubmitButton(),

                // Envie o formulário quando todos os campos forem válidos
                defaultSubmit: new FormValidation.plugins.DefaultSubmit

            }
        }).on('core.form.invalid', function () {
            Swal.fire({
                text: "Existems campos que são de preenchimentos obrigatórios.",
                icon: "error",
                buttonsStyling: !1,
                confirmButtonText: "OK, entendi!",
                customClass: {
                    confirmButton: "btn font-weight-bold btn-light"
                }
            }).then(function () {
                KTUtil.scrollTop();
            });
        }).on('core.form.valid', function () {
            KTApp.block('body', {
                overlayColor: '#1bc5bd',
                opacity: 0.1,
                state: 'success',
                size: 'lg', //available custom sizes: sm|lg
                message: 'Processando...'
            });
        });
    };
    /* form-coache-add */


    /* form-coache-edit */
    var initCoacheEdit = function (element) {
        FormValidation.formValidation(document.getElementById(element), {
            fields: {

                nome: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 3,
                            max: 100,
                            message: 'Deve conter no mínimo 3 e no máximo 100 caracteres'
                        }
                    }
                },
                nomeCasual: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 2,
                            max: 20,
                            message: 'Deve conter no mínimo 2 e no máximo 20 caracteres'
                        }
                    }
                },
                cpf: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        }
                    }
                },
                idSexo: {
                    validators: {
                        greaterThan: {
                            message: 'Preenchimento obrigatório.',
                            min: 1
                        }
                    }
                },
                dataNascimento: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        date: {
                            format: 'DD/MM/YYYY',
                            message: 'Informe uma data válida.'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        emailAddress: {
                            message: 'Informe um email válido.'
                        }
                    }
                },
                telefone: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        }
                    }
                }


            },
            plugins: {
                trigger: new FormValidation.plugins.Trigger,
                bootstrap: new FormValidation.plugins.Bootstrap,

                // Valide campos ao clicar no botão Enviar
                submitButton: new FormValidation.plugins.SubmitButton(),

                // Envie o formulário quando todos os campos forem válidos
                defaultSubmit: new FormValidation.plugins.DefaultSubmit

            }
        }).on('core.form.invalid', function () {
            Swal.fire({
                text: "Existems campos que são de preenchimentos obrigatórios.",
                icon: "error",
                buttonsStyling: !1,
                confirmButtonText: "OK, entendi!",
                customClass: {
                    confirmButton: "btn font-weight-bold btn-light"
                }
            }).then(function () {
                KTUtil.scrollTop();
            });
        }).on('core.form.valid', function () {
            KTApp.block('body', {
                overlayColor: '#1bc5bd',
                opacity: 0.1,
                state: 'success',
                size: 'lg', //available custom sizes: sm|lg
                message: 'Processando...'
            });
        });
    };
    /* form-coache-edit */


   

    return {
        // public functions
        init: function () {         

            if (document.getElementById('form-coache-add')) {
                initCoacheAdd('form-coache-add');
            }
            if (document.getElementById('form-coache-edit')) {
                initCoacheEdit('form-coache-edit');
            }          

        }
    };
}();

jQuery(document).ready(function () {
    KTFormControls.init();
});
