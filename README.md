JSON homework: 
HospitalContainer class:
This class serves as a wrapper for the Hospital object, allowing for easier serialization and deserialization of the Hospital data structure to and from JSON.

JSONParser class:
This class handles the parsing of JSON files into Java objects and vice versa.

Updated main application logic to include:
Creation of sample Hospital data, including Departments and Doctors.
Serialization of a HospitalContainer instance to JSON and saving it to a file, with logging of the serialized JSON.
Deserialization of the JSON file back into a HospitalContainer object, followed by logging of the deserialized Hospital.
Included a separate read method to demonstrate reading the JSON directly into a HospitalContainer.


JAXB homework:
Added JAXB annotations to the class hierarchy to support XML serialization and deserialization.
Included JAXB annotations for handling complex objects, Lists, and Date fields.
Implemented parsing of XML data into Java objects using JAXB Unmarshaller.

XML homework:
XMLValidator Class: To validate an XML file against an XSD schema.
XMLParser Class: To read and parse the content of an XML file.
XML File (hospital.xml): To store structured information about the hospital, such as departments, doctors, nurses, patients, rooms, and appointments.
XSD File (hospital.xsd):To define the rules and structure that the XML file must follow.

DAO homework: 
AbstractDAO Class: To serve as a base class that provides reusable CRUD (Create, Read, Update, Delete) operations for various entities in the clinic system.
DoctorDAO Class: A subclass of AbstractDAO responsible for handling Doctor-specific database operations.
DoctorServiceImpl Class: Provides a higher-level service for managing Doctor entities, using the DoctorDAO for database operations.
GenericDAO Interface: To define a generic contract for DAOs, providing basic CRUD operations for any entity type.
