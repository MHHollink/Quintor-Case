# MediaLibrary

This repository contains the code base for the CD library case that is presented by Quintor BV. as an knowledge test.
The case contains the following technologies :

## Backend

* Java Enterprise Edition
* Jax-RS
* JPA
* JSR303
* CDI
* Arquillian

## Frontend 

* Angular2
* HTML
* CSS

# REST

Since this is a REST webservice there must be a way to communicate with it. There are multiple calls inside the REST API that can be used to get the wanted data.
The Application contains 3 main resources. 

* /artists
* /artists/{artistId}
* /artists/{artistId}/albums
* /artists/{artistId}/albums/{albumId}
* /artists/{artistId}/albums/{albumId}/songs
* /artists/{artistId}/albums/{albumId}/songs/{songId}