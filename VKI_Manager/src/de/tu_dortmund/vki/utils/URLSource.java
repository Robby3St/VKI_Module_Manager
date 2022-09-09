package de.tu_dortmund.vki.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class URLSource {
	private String sourceName;
	private String sourceURL;
	private String[] moreSourcesURLs;
	private String[] sourceAuthors;
	private String lastAccessDate;
	
	
	
	// -- Constructors --
	
	public URLSource(String sourceName) {
		this.sourceName = sourceName;
	}
	
	public URLSource(String sourceName, String sourceURL) {
		this.sourceName = sourceName;
		this.sourceURL = sourceURL;
	}
	
	public URLSource(String sourceName, String[] moreSourcesURLs) {
		this.sourceName = sourceName;
		this.moreSourcesURLs = moreSourcesURLs;
	}
	
	public URLSource(String sourceName, String[] moreSourcesURLs, String[] sourceAuthors) {
		this.sourceName = sourceName;
		this.moreSourcesURLs = moreSourcesURLs;
		this.sourceAuthors = sourceAuthors;
	}
	
	
	// Methods
	
	public String[] getSourceInfos() {
		List<String> sourceInfos = new LinkedList<String>();
		if(this.sourceName != null)
			sourceInfos.add(this.sourceName);
		if(this.sourceURL != null)
			sourceInfos.add(this.sourceURL);
		if(this.moreSourcesURLs != null)
			sourceInfos.add("More Sources: " + Arrays.toString(this.moreSourcesURLs));
		if(this.sourceAuthors != null)
			sourceInfos.add("Source Authors: " + Arrays.toString(this.sourceAuthors));
		if(this.lastAccessDate != null)
			sourceInfos.add("Last accessed this source: " + this.lastAccessDate);
		
		Object[] arr = sourceInfos.toArray();
		String[] result = Arrays.copyOf(arr, arr.length, String[].class);
		return result;
	}
	
	
	
	// -- Getter / Setter --
	
	public URLSource(String sourceName, String sourceURL, String[] moreSourcesURLs, String[] sourceAuthors,
			String lastAccessDate) {
		this.sourceName = sourceName;
		this.sourceURL = sourceURL;
		this.moreSourcesURLs = moreSourcesURLs;
		this.sourceAuthors = sourceAuthors;
		this.lastAccessDate = lastAccessDate;
	}

	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getSourceURL() {
		return sourceURL;
	}
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}
	public String[] getSourceAuthors() {
		return sourceAuthors;
	}
	public void setSourceAuthors(String[] sourceAuthors) {
		this.sourceAuthors = sourceAuthors;
	}
	public String getLastAccessDate() {
		return lastAccessDate;
	}
	public void setLastAccessDate(String lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public String[] getMoreSourcesURLs() {
		return moreSourcesURLs;
	}

	public void setMoreSourcesURLs(String[] moreSourcesURLs) {
		this.moreSourcesURLs = moreSourcesURLs;
	}
	
	
}
