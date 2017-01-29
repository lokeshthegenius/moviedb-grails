package mdb

import grails.rest.*

@Resource(uri = '/api/movies', readOnly = false, formats = ['json', 'xml'])
class Movies {
    String title
    int releaseYear
    String summary
    Genres genre
    Directors director

//    static hasMany = [genre: Genres]
//    static hasOne = [director: Directors]
}