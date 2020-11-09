"use strict";
// Class definition

var KTDatatableHtmlTableDemo = function () {
    // Private functions

    // demo initializer
    var demo = function () {

        var datatable = $('#kt_datatable').KTDatatable({
            data: {
                saveState: {cookie: false},
            },
            search: {
                input: $('#kt_datatable_search_query'),
                key: 'generalSearch'
            },
            columns: [
                {
                    field: 'DepositPaid',
                    type: 'number',
                },
                {
                    field: 'OrderDate',
                    type: 'date',
                    format: 'YYYY-MM-DD',
                },

                /*{
                 field: 'Sexo',
                 title: 'Sexo',
                 autoHide: false,
                 // callback function support for column rendering
                 template: function(row) {
                 var sexo = {
                 1: {
                 'title': 'Masculino',
                 'class': ' label-primary'
                 },
                 2: {
                 'title': 'Feminino',
                 'class': ' label-info'
                 },						
                 };
                 return '<span class="label font-weight-bold label-lg' + sexo[row.Sexo].class + ' label-inline">' + sexo[row.Sexo].title + '</span>';
                 },
                 }, */

              /*  {
                    field: 'Status',
                    title: 'Status',
                    autoHide: false,
                    // callback function support for column rendering
                    template: function (row) {
                        var status = {
                            1: {
                                'title': 'Online',
                                'state': 'success'
                            },
                            2: {
                                'title': 'Offline',
                                'state': 'danger'
                            },
                        };
                        return '<span class="label label-' + status[row.Status].state + ' label-dot mr-2"></span><span class="font-weight-bold text-' + status[row.Status].state + '">' + status[row.Status].title + '</span>';
                    },
                },*/
                
                
            ],
        });



        $('#kt_datatable_search_status').on('change', function () {
            datatable.search($(this).val().toLowerCase(), 'Status');
        });

        $('#kt_datatable_search_type').on('change', function () {
            datatable.search($(this).val().toLowerCase(), 'Type');
        });

        $('#kt_datatable_search_status, #kt_datatable_search_type').selectpicker();

    };

    return {
        // Public functions
        init: function () {
            // init dmeo
            demo();
        },
    };
}();

jQuery(document).ready(function () {
    KTDatatableHtmlTableDemo.init();
});
