# Timeline Visualization of Cultural Heritage

My dissertation project for MSc Computer Sciene at Birkbeck College, University of London.

## Problem Area

Multiple culturual heritage institutions, such as the British Museum, are now making information about their collections available as semantic networked data to the public through SPARQL endpoints.
However, public interaction with the data has been limited by a lack of interfaces with which to manipulate and explore the data; it is generally only accessible to professionals with knowledge of semantic web technologies.
This project created an application allowing non-technically-minded cutural heritage professionals the capability of querying multiple SPARQL endpoints and visualizing the results.

## Outcome

The application was created with all necessary components: the ability to query multiple SPARQL-endpoints simultaneously, visualization of data (with photographs) on multiple timelines, an ability to examine the properties of specific items in more detail, and an ability to filter the results.
However, the elements in some cases might have been improved; this was not possible due to the large amount of time that was taken by dealing with the SPARQL-endpoints, which had multiple problems such as being irresponsive to queries and often being unavailable for quering.

## Tooling

The code for this project was written in Java using the NetBeans Platform and Swing GUI Toolkit.
Apache Jena was used for forming SPARQL queries and communicating with SPARQL endpoints.

## Further Reading

The final report can be read here:
https://github.com/James-G-Hill/Final-Project-Computer-Science-CIDOC-CRM-Timeline/blob/master/Project%20Report.pdf
