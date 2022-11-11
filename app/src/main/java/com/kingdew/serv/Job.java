package com.kingdew.serv;

public class Job {

    int jobID;
    String JobName,jobPrice,jobStatus,jobOwner,jobCompleter,jobPhotos,jobDesc,jobAddress,jobTele;

    public Job(int jobID, String jobName, String jobPrice, String jobStatus, String jobOwner, String jobCompleter, String jobPhotos, String jobDesc, String jobAddress, String jobTele) {
        this.jobID = jobID;
        this.JobName = jobName;
        this.jobPrice = jobPrice;
        this.jobStatus = jobStatus;
        this.jobOwner = jobOwner;
        this.jobCompleter = jobCompleter;
        this.jobPhotos = jobPhotos;
        this.jobDesc = jobDesc;
        this.jobAddress = jobAddress;
        this.jobTele = jobTele;
    }

    public Job(int jobID, String jobName, String jobPrice, String jobStatus, String jobOwner, String jobPhotos, String jobDesc, String jobAddress, String jobTele) {
        this.jobID = jobID;
        this.JobName = jobName;
        this.jobPrice = jobPrice;
        this.jobStatus = jobStatus;
        this.jobOwner = jobOwner;
        this.jobPhotos = jobPhotos;
        this.jobDesc = jobDesc;
        this.jobAddress = jobAddress;
        this.jobTele = jobTele;
    }


    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public String getJobPrice() {
        return jobPrice;
    }

    public void setJobPrice(String jobPrice) {
        this.jobPrice = jobPrice;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobOwner() {
        return jobOwner;
    }

    public void setJobOwner(String jobOwner) {
        this.jobOwner = jobOwner;
    }

    public String getJobCompleter() {
        return jobCompleter;
    }

    public void setJobCompleter(String jobCompleter) {
        this.jobCompleter = jobCompleter;
    }

    public String getJobPhotos() {
        return jobPhotos;
    }

    public void setJobPhotos(String jobPhotos) {
        this.jobPhotos = jobPhotos;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getJobTele() {
        return jobTele;
    }

    public void setJobTele(String jobTele) {
        this.jobTele = jobTele;
    }
}
