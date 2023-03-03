Al arrancar la aplicación, se añadiran un Cliente, una Factura y dos Lineas de Facturas
asociadas a la Factura mencionada anteriormente.

Tambien, tenemos un JSON de pruebas de lo que hace la aplicación,
1- Un GET de la Factura con su cliente y Lineas de Factura asociados 
2- Un DELETE de la Factura y sus Lineas de Factura asociados (Tambien si intentamos eliminar una Factura inexistente)
3- Un POST de Linea de Factura al que asociamos a una Factura ya Creada (La que se crea por defectoc audno se inicializa el programa) ->(Tambien si intentamos asociar lineas de factura a facturas inexistentes y con nombres de productos tanto vacios como inexistentes)

