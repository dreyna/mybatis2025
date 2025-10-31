$(document).ready(function () {
 listar();

});
function listar() {
    $.ajax({
        url: "/productos",
        type: 'GET',
        success: function (x) {

            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].id + "</td><td>" + x[i].nombre
                        + "</td><td>" + x[i].precio + "</td><td>" + x[i].cantidad + "</td><td><a href='#' onclick='editar("
                        + x[i].id + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].id + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }


        }
    });
}
function editar(id) {
    $.ajax({
        url: "/productos/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombre").val(w.nombre);
            $("#editar_precio").val(w.precio);
            $("#editar_cantidad").val(w.cantidad);
            $("#idprod").val(w.id);
        }
    });
    $("#modalEditar").modal('show');
}
function eliminar(id) {

    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/productos/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}
$("#guardar").click(function () {
    let nombre = $("#nombre").val();
    let precio = $("#precio").val();
    let cantidad = $("#cantidad").val();
    //alert(nombre+"|"+precio+"|"+cantidad);
    $.ajax({
        url: "/productos",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombre': nombre, 'precio': precio, 'cantidad':cantidad}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            limpiar();
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});
function limpiar() {
    $("#titulo").val("");
    $("#descripcion").val("");
}
$("#modificar").click(function () {
    let nombre = $("#editar_nombre").val();
    let precio = $("#editar_precio").val();
    let cantidad = $("#editar_cantidad").val();
    var id = $("#idprod").val();
    
 //alert(nombre+"|"+precio+"|"+cantidad+"|"+id);
    
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/productos/"+ id,
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'id': id, 'nombre': nombre, 'precio': precio, 'cantidad':cantidad}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});