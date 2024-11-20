terraform {
  backend "s3" {
    bucket = "chandu234-123"
    key = "chandu"
    region = "ap-south-1"
    dynamodb_table = "terraform-lock"
    
  }
}