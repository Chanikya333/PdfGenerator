Build a Spring Boot Application with REST API to GENERATE PDF using Java Template
Engine.

Overview:
This project handles the below requirements
● REST API to accept data and generate a PDF based on the received data.
● Ability to download the above-generated PDF
● Store the above-generated PDF on the local storage and redownload it when the
same data is provided instead of generating it again.

Example
The request body of the API call looks something like this:

{
"seller": "XYZ Pvt. Ltd.",
"sellerGstin": "29AABBCCDD121ZD",
"sellerAddress": "New Delhi, India",
"buyer": "Vedant Computers",
"buyerGstin": "29AABBCCDD131ZD",
"buyerAddress": "New Delhi, India",
"items": [
{
"name": "Product 1",
"quantity": "12 Nos",
"rate": 123.00,
"amount": 1476.00
}
]
}

You can check the result in postman using the api: http://localhost:8080/api/generate-pdf
