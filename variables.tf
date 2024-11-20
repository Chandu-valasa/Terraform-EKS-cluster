# Copyright (c) HashiCorp, Inc.
# SPDX-License-Identifier: MPL-2.0

variable "region" {
  description = "AWS region"
  type        = string
  default     = "ap-south-1"
}

variable "cidr" {
  type=string
  default = "10.0.0.0/16"
  
}
