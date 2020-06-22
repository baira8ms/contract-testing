import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method POST()
        url("/applicant")
        body("""
{"applicantName":"Bhanu", "purposeOfVisit":"business"}
""")
        headers {
            contentType("application/json")
//            header("Charset", "ISO-8859-1")
        }
    }

    response {
        body("""created""")
        status 201
    }
}