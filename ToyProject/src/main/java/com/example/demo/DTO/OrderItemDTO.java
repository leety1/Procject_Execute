package com.example.demo.DTO;

import lombok.Data;
@Data
public class OrderItemDTO {
		private String id;
		private String name;
		private String pants;
		private String card;
		
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPants() {
			return pants;
		}
		public void setPants(String pants) {
			this.pants = pants;
		}
		public String getCard() {
			return card;
		}
		public void setCard(String card) {
			this.card = card;
		}
		
}
