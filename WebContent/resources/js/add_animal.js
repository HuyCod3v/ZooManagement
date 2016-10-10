/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cell_on_region() {
    regionID = $("#region_id").val();
    $.get("CellJsonServlet", {
        regionID: regionID
    }, function(responseJSON) {
        var $cell_select = $("#cell_id");
        $cell_select.find('option').remove();
        $.each(responseJSON, function(key, value) {
            $cell_select.prepend($('<option></option>').attr("value", key).text(value));
        });
    });
}


$(document).ready(function() {
    jQuery.validator.setDefaults({
        success: "valid"
    });
    $("#frm-add-animal").validate({
        ignore: [],
        debug: false,
        rules: {
            animal_id: {
                required: true,
                maxlength: 10,
            },
            animal_name: {
                required: true,
                maxlength: 30
            },
            species_id: {
                required: true,
                maxlength: 10,
            },
            gender: {
                required: true,
            },
            weight: {},
            height: {},
            health_status: {
                required: true,
                maxlength: 30
            },
            description: {
                maxlength: 1000
            },
            cell_id: {
                required: true,
                maxlength: 10
            },
        },
        messages: {
            animal_id: {
                required: "<span style='color:red;'>Cần phải nhập mã động vật</span>",
                maxlength: "<span style='color:red;'>Mã động vật tối đa là 10 ký tự</span>",
            },
            animal_name: {
                required: "<span style='color:red;'>Cần phải nhập tên động vật</span>",
                maxlength: "<span style='color:red;'>Tên động vật tối đa là 30 ký tự</span>"
            },
            species_id: {
                required: "<span style='color:red;'>Cần phải chọn loài cho động vật</span>",
                maxlength: "<span style='color:red;'>Mã loài tối đa là 10 ký tự</span>",
            },
            gender: {
                required : "<p style='color:red;'>Vui lòng chọn giới tính</p>",
            },
            weight: {},
            height: {},
            health_status: {
                required: "<span style='color:red;'>Cần phải nhập tình trạng sức khỏe động vật</span>",
                maxlength: "<span style='color:red;'>Tình trạng sức khỏe tối đa là 30 ký tự</span>"
            },
            description: {
                maxlength: "<span style='color:red;'>Mô tả tối đa là 1000 ký tự</span>",
            },
            cell_id: {
                required: "<span style='color:red;'>Cần phải chọn chuồng cho động vật</span>",
                maxlength: "<span style='color:red;'>Mã chuồng tối đa là 10 ký tự</span>",
            },
        }
    });

    cell_on_region();
    $("#region_id").change(cell_on_region);
});
