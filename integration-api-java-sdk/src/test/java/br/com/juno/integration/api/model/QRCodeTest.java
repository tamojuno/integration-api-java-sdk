package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.QRCode.JunoCreateResultType;
import br.com.juno.integration.api.model.QRCode.PicpayCreateResultType;
import br.com.juno.test.AbstractTest;

public class QRCodeTest extends AbstractTest {

    @Test
    public void constructors() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void toStringEmpty() {
        // NTD
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringComplete() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void equality() {
        // NTD
    }

    public String findOneComplete() {
        // NTD
        return "{\"referenceId\":\"8bbe1083-ffba-4c26-aa05-2fb63a2c1686\",\"qrcodeContent\":\"https:\\/\\/app.picpay.com\\/checkout\\/NWUxNGI1MGRhMDIzYWEwYTVkNDMxMTky\",\"qrcodeBase64\":\"data:image\\/png;base64,iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQCAIAAAAP3aGbAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAIX0lEQVR4nO3dwW4bORRFwTjI\\/3+yMYsAWWU4Coeh32lV7W21ZPmgFxfsj8\\/Pz28ABd+\\/+gIAXiVYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQMaPr76Af\\/X9ezimn5+fGz+1eMt7v3DvtRYWlzHk7zXkkx\\/yaew5\\/mU7KPyxAu9GsIAMwQIyBAvIECwgQ7CADMECMgQLyJg7HF0YMmzbGwcenxQen4DefK2bW9mFp77WQnTamrxo4D0JFpAhWECGYAEZggVkCBaQIVhAhmABGcnh6MLxOdzxmd\\/eivLmOnSIvU3pzT3kkGNgF9JfgN9yhwVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARlPG47ON\\/8Z8TdPAb35ZPn5S1T+kz8GkCFYQIZgARmCBWQIFpAhWECGYAEZggVkGI7eNmQquTBkRTnkrNfnHdqZ5g4LyBAsIEOwgAzBAjIEC8gQLCBDsIAMwQIynjYcnT\\/zS5\\/nefy1bpq\\/Dh1yGZO5wwIyBAvIECwgQ7CADMECMgQLyBAsIEOwgIzkcNTTw190fCp580HwQ1aUx6\\/Qt\\/f\\/8NkBGYIFZAgWkCFYQIZgARmCBWQIFpAhWEDGx5B5Hn\\/DzQfcL8wfWPovqHCHBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGXNPHB1yMOPNgeWeIaPH45dx\\/Bfu\\/b32fmrI0azzD3T9UyP+5QBeIVhAhmABGYIFZAgWkCFYQIZgARmCBWTMPXH0qQdOHh8iHnfzxNEhZ6IuHL+MIYPYhbFN+OYOCwgRLCBDsIAMwQIyBAvIECwgQ7CADMECMuaeOHr8+eZDjnM8PkQcMl\\/c+4VDNopDDu0ccrrpZO6wgAzBAjIEC8gQLCBDsIAMwQIyBAvIECwgY+5wdM\\/NEd3NIzFvrkPnT3bTjr\\/lt\\/oM3WEBGYIFZAgWkCFYQIZgARmCBWQIFpAhWEDG3EfV77k5sLz5mPUhT3u\\/+W25ObA87uao+GH\\/wmvusIAMwQIyBAvIECwgQ7CADMECMgQLyBAsIONpJ44ed\\/MgzcVPDVmHPnV7uXcZC0NOAZ0\\/D\\/5T7rCADMECMgQLyBAsIEOwgAzBAjIEC8gQLCBj7nD05pPl99ycL+6Zv70c8hke\\/25M3l7+NP8Kf2vE1wXgFYIFZAgWkCFYQIZgARmCBWQIFpAhWEDG3OHonptzuPkPTL95XOqe4xvgm0ezLgw5Bja6Dl1whwVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARnJ4eiQceDeZQyZm87fr978hfPPRF14q03p9D8GwC+CBWQIFpAhWECGYAEZggVkCBaQIVhAxkdxPzbkMesL84\\/6vHnu5fFfePPTuPmWF+Zf4R3usIAMwQIyBAvIECwgQ7CADMECMgQLyBAsIGPucHT+SY97hpw4mp4v2uX+1Z+a7JlRAB5JsIAMwQIyBAvIECwgQ7CADMECMgQLyEgOR29uL4fsPPcMWYfeXDbeXNjOf8tj\\/7u3jfi\\/AniFYAEZggVkCBaQIVhAhmABGYIFZAgWkPHjqy8gbMgCcMhU8uZr3dxDHr+M4295\\/md4kDssIEOwgAzBAjIEC8gQLCBDsIAMwQIyBAvIeNpw9OaxovNPlbz5aSzM30MeH8Sm3\\/LkTak7LCBDsIAMwQIyBAvIECwgQ7CADMECMgQLyHjacHT+LHPIBHTxC2\\/OTW\\/OF4fMTY+PVPdMXocujPjsAF4hWECGYAEZggVkCBaQIVhAhmABGYIFZHyM3Y+94RGLQ5aNQ44wPT6wnP+A+\\/RbvsMdFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZDztxNGbzxw\\/7uaTym\\/OF\\/ccn5sOeV83x7d7lzF5bjriTwjwCsECMgQLyBAsIEOwgAzBAjIEC8gQLCBj7omjTxUd7P00f\\/S45+Zkd+H4OaVD3tdB7rCADMECMgQLyBAsIEOwgAzBAjIEC8gQLCBj7nB0yPmQe24+7d3j4180f2465HjbycJRAN6NYAEZggVkCBaQIVhAhmABGYIFZAgWkJF8VP2QzduQ4zePv9aQ9\\/XU5fBNQy7joPB3Ang3ggVkCBaQIVhAhmABGYIFZAgWkCFYQEZyOLow\\/0jMIbPM469189HnQw50HTJtfd46dGHEJw7wCsECMgQLyBAsIEOwgAzBAjIEC8gQLCDjacPRtL0F4JBHn+8Z8kj345cxZNr6vE3p9C80wC+CBWQIFpAhWECGYAEZggVkCBaQIVhAhuFow944cP6mNL2VvbkO3fO8TemIby3AKwQLyBAsIEOwgAzBAjIEC8gQLCBDsICMpw1Ho3O4n47P\\/G7OF4csUfcc\\/9oc35QOWaJ+ufCXDHg3ggVkCBaQIVhAhmABGYIFZAgWkCFYQEZyOJreKC7cnPmlHwS\\/sPcL09+ot3qKffjvBLwbwQIyBAvIECwgQ7CADMECMgQLyBAsIOMjuh8D3pA7LCBDsIAMwQIyBAvIECwgQ7CADMECMgQLyBAsIEOwgAzBAjIEC8gQLCBDsIAMwQIyBAvIECwgQ7CADMECMgQLyBAsIEOwgAzBAjIEC8gQLCBDsIAMwQIyBAvIECwgQ7CADMECMgQLyBAsIEOwgAzBAjIEC8gQLCBDsIAMwQIyBAvIECwgQ7CADMECMgQLyBAsIEOwgAzBAjIEC8gQLCBDsIAMwQIy\\/gE\\/PAW5mxAXYAAAAABJRU5ErkJggg==\",\"paymentUrl\":\"https:\\/\\/app.picpay.com\\/checkout\\/NWUxNGI1MGRhMDIzYWEwYTVkNDMxMTky\",\"expiresAts\":\"2020-01-09 00:00:00\",\"picpayResult\":\"SUCCESS\",\"junoResult\":\"SUCCESS\"}";
    }

    public String findOneNull() {
        // NTD
        return "{\"referenceId\":null,\"qrcodeContent\":null,\"qrcodeBase64\":null,\"paymentUrl\":null,\"expiresAts\":null,\"picpayResult\":null,\"junoResult\":null}";
    }

    public String findCompleteObject() {
        // NTD
        QRCode qrcode = new QRCode();
        qrcode.setReferenceId("8bbe1083-ffba-4c26-aa05-2fb63a2c1686");
        qrcode.setQrcodeContent("https://app.picpay.com/checkout/NWUxNGI1MGRhMDIzYWEwYTVkNDMxMTky");
        qrcode.setQrcodeBase64(
                "data:image/png;base64,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");
        qrcode.setPaymentUrl("https://app.picpay.com/checkout/NWUxNGI1MGRhMDIzYWEwYTVkNDMxMTky");
        qrcode.setExpiresAt("2020-01-09 00:00:00");
        qrcode.setPicpayResult(PicpayCreateResultType.SUCCESS);
        qrcode.setJunoResult(JunoCreateResultType.SUCCESS);
        return qrcode.toString();
    }

    public String findIncompleteObject() {
        QRCode qrcode = new QRCode();
        qrcode.getReferenceId();
        qrcode.getQrcodeContent();
        qrcode.getQrcodeBase64();
        qrcode.getPaymentUrl();
        qrcode.getExpiresAt();
        qrcode.getPicpayResult();
        qrcode.getJunoResult();
        return qrcode.toString();
    }
}
