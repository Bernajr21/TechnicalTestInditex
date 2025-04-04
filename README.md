# TechnicalTestInditex

# 🛍️ Similar Products API

This is a Spring Boot application that exposes an API endpoint to retrieve similar products for a given product.  
The product data is retrieved from a mock service running locally via Docker.

---

## 🔗 Endpoint

### `GET /product/{productId}/similar`

Returns a list of similar products with full details for a given `productId`.

#### ✅ Sample response:

```json
[
  {
    "id": "2",
    "name": "Product 2",
    "description": "Description of product 2",
    "price": 29.99
  },
  {
    "id": "3",
    "name": "Product 3",
    "description": "Description of product 3",
    "price": 45.00
  }
]

