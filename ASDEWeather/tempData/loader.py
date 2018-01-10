import json
import sys
import csv



class City:
    def __init__(self,name,cityid,country,latitude,longitude):
        self.name = name.encode("utf-8").replace("'",r"\'")
        self.cityid = str(cityid)
        self.country = country.encode("utf-8").replace("'",r"\'")
        self.latitude = str(latitude)
        self.longitude = str(longitude)



def writeCityQuery(city):
    string = ("insert into City (id,name,latitude,longitude, country_id) values ("+
              city.cityid+
              ","+
              "'"+city.name+
              "'"+
              ","+
              city.latitude+
              ","+
              city.longitude+
              ","+
              "(select id from country where code="+
              "'"+
              city.country+
              "'"+
              ") );\n")
    write_to.write(string)


def writeCountryQuery(country):
        countryName = row[0].replace("'",r"\'")
        countryCode = row[1]
        string = ("insert into Country (id,name,code) values("+
                 "NULL"+
                 ","+
                 "'"+
                 countryName+
                 "'"+
                 ","+
                 "'"+
                 countryCode+
                 "'"+
                 ");\n"
                 )
        write_to.write(string)

#City
with open('city.list.json','r') as f:
    write_to = open("../resources/hibernate_import/importCities.sql","w")
    #Load Json to python dictionary
    data = json.load(f)
    visited = []
    #Loop throught elements
    #count = 0;
    for i in data:
            city = City(i['name'],i['id'],i['country'],i['coord']['lat'],i['coord']['lon'])
            writeCityQuery(city)
    write_to.close()

with open('SimpleCountryList.csv') as f:
    write_to = open("../resources/hibernate_import/importCountry.sql","w")
    data = csv.reader(f,delimiter=",")
    for row in data:
        writeCountryQuery(row)

