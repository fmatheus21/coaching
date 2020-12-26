/* global FormValidation, KTUtil, KTApp, Swal */

// Class definition
var KTFormControls = function () {
    // Private functions



    /* form-coache-add */
    var initCoacheAdd = function (element) {
        FormValidation.formValidation(document.getElementById(element), {
            fields: {

                name: {
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
                casualName: {
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
                idGender: {
                    validators: {
                        greaterThan: {
                            message: 'Preenchimento obrigatório.',
                            min: 1
                        }
                    }
                },
                dateBirth: {
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
                phone: {
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

                name: {
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
                casualName: {
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
                idGender: {
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
                phone: {
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


    /* form-assessment-add */
    var initAssessmentAdd = function (element) {
        FormValidation.formValidation(document.getElementById(element), {
            fields: {

                coache: {
                    validators: {
                        greaterThan: {
                            message: 'Preenchimento obrigatório.',
                            min: 1
                        }
                    }
                },
                titulo: {
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
                descricao: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 5,
                            message: 'Deve conter no mínimo 5 caracteres'
                        }
                    }
                },
                nomeAvaliado: {
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
                emailAvaliado: {
                    validators: {
                        notEmpty: {
                            message: 'Preenchimento obrigatório.'
                        },
                        emailAddress: {
                            message: 'O valor não é um endereço de email válido'
                        }
                    }
                },
                envioEmail: {
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
    /* form-assessment-add */



    /* form-team-coaching-add */
    var initTeamCoachingAdd = function (element) {
        FormValidation.formValidation(document.getElementById(element), {
            fields: {
                nomeTurma: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 3,
                            max: 50,
                            message: 'Deve conter no mínimo 3 e no máximo 50 caracteres'
                        }
                    }
                },
                '[0][nome]': {
                    validators: {
                        /*choice: {
                         min: 2,
                         max: 4,
                         message: 'Please choose 2 - 4 programming languages you are good at'
                         }*/
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 3,
                            max: 50,
                            message: 'Deve conter no mínimo 3 e no máximo 50 caracteres'
                        }
                    }
                },
                '[0][email]': {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        emailAddress: {
                            message: 'O valor não é um endereço de email válido'
                        }
                    }
                },
                '[0][telefone]': {
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
    /* form-team-coaching-add */

    /* form-team-coaching-edit */
    var initTeamCoachingEdit = function (element) {
        FormValidation.formValidation(document.getElementById(element), {
            fields: {
                nomeTurma: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 3,
                            max: 50,
                            message: 'Deve conter no mínimo 3 e no máximo 50 caracteres'
                        }
                    }
                },
                '[0][nome]': {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        stringLength: {
                            min: 3,
                            max: 50,
                            message: 'Deve conter no mínimo 3 e no máximo 50 caracteres'
                        }
                    }
                },
                '[0][email]': {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        },
                        emailAddress: {
                            message: 'O valor não é um endereço de email válido'
                        }
                    }
                },
                '[0][telefone]': {
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
    /* form-team-coaching-edit */
    
    
     /* form-initMindfulness */
    var initMindfulness = function (element) {
        FormValidation.formValidation(document.getElementById(element), {
            fields: {
                   idExerciseMindfulness: {
                    validators: {
                        greaterThan: {
                            message: 'Preenchimento obrigatório.',
                            min: 1
                        }
                    }
                },

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
    /* form-mindfulness */


    return {
        // public functions
        init: function () {

            if (document.getElementById('form-coache-add')) {
                initCoacheAdd('form-coache-add');
            }
            if (document.getElementById('form-coache-edit')) {
                initCoacheEdit('form-coache-edit');
            }
            if (document.getElementById('form-assessment-add')) {
                initAssessmentAdd('form-assessment-add');
            }
            if (document.getElementById('form-team-coaching-add')) {
                initTeamCoachingAdd('form-team-coaching-add');
            }
            if (document.getElementById('form-team-coaching-edit')) {
                initTeamCoachingEdit('form-team-coaching-edit');
            }
             if (document.getElementById('form-mindfulness')) {
                initMindfulness('form-mindfulness');
                console.log('form-mindfulness...............')
            }
            
            

        }
    };
}();

jQuery(document).ready(function () {
    KTFormControls.init();
});
