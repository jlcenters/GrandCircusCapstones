package co.grandcircus.Capstone7.Entities;

import java.util.List;

public class SearchResult {
	
	private String q;
	private List<Hit> hits;
	private Integer count;
	private Boolean more;
	private Integer to;
	private Integer from;
	
	public String getQ() {
		return q;
	}
	
	public void setQ(String q) {
		this.q = q;
	}
	
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public List<Hit> getHits() {
		return hits;
	}
	public void setHits(List<Hit> hits) {
		this.hits = hits;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Boolean getMore() {
		return more;
	}
	public void setMore(Boolean more) {
		this.more = more;
	}
	
	

}
