/* global FormValidation, KTApp, KTUtil */

"use strict";

// Class Definition
var KTLogin = function () {
    var _login;
    var _showForm = function (form) {
        var cls = 'login-' + form + '-on';
        var form = 'kt_login_' + form + '_form';
        _login.removeClass('login-forgot-on');
        _login.removeClass('login-signin-on');
        _login.removeClass('login-signup-on');
        _login.addClass(cls);
        KTUtil.animateClass(KTUtil.getById(form), 'animate__animated animate__backInUp');
    };

    var _handleSignInForm = function () {

        // Handle forgot button
        $('#kt_login_forgot').on('click', function (e) {
            e.preventDefault();
            _showForm('forgot');
        });

        // Handle signup
        $('#kt_login_signup').on('click', function (e) {
            e.preventDefault();
            _showForm('signup');
        });
    }

    var _handleSignUpForm = function (e) {


        // Handle cancel button
        $('#kt_login_signup_cancel').on('click', function (e) {
            e.preventDefault();

            _showForm('signin');
        });
    }

    var _handleForgotForm = function (e) {
        // Handle cancel button
        $('#kt_login_forgot_cancel').on('click', function (e) {
            e.preventDefault();
            _showForm('signin');
        });
    }






    /* Validation Login */
    var validationLogin = function () {
        FormValidation.formValidation(document.getElementById("kt_login_signin_form"), {
            fields: {

                username: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
                        }

                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: "Preenchimento obrigatório."
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
    /* Validation Login */



    // Public Functions
    return {
        // public functions
        init: function () {
            _login = $('#kt_login');
            _handleSignInForm();
            _handleSignUpForm();
            _handleForgotForm();
            validationLogin();
        }
    };
}();

// Class Initialization
jQuery(document).ready(function () {
    KTLogin.init();
});
