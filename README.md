# apiPrices

Desarrollo de endPoint para obtener los datos de la consulta solicitada por 3 parametros:
- String date. (usar formato: [yyyy-MM-dd HH:mm:ss] -> 2020-06-16 21:00:00).
- Integer productId.
- Integer brandId.

Y devolviendo la respuesta en el siguiente objeto:
{
"productId": 0,
"brandId": 0,
"priceList": 0,
"startDate": "2023-03-12.16.08.00",
"endDate": "2023-03-12.16.08.00",
"price": 0
}




Criterios solicitados (TEST) :

     Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
     Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
Se documenta el endpoint con open-api y se visualiza en swagger.

Tecnologías usadas:

Spring-boot
Maven
H2
Junit
Mockito
flyway
Swagger : url ( http://localhost:4000/swagger-ui/index.html )