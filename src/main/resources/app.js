const API = "/api";

const candidateId = 1;

document.addEventListener("DOMContentLoaded", () => {
    loadJobs();
    loadApplications();
    loadApplicants();
});


async function loadJobs() {

    const container = document.getElementById("jobList");

    try {

        const response = await fetch("/api/jobs");

        if (!response.ok) {
            throw new Error("Jobs API returned " + response.status);
        }

        const jobs = await response.json();

        console.log("Jobs received:", jobs);

        if (!Array.isArray(jobs) || jobs.length === 0) {
            container.innerHTML = `
                <div class="job-card">
                    <h3>No Jobs Available</h3>
                    <p>There are currently no active job openings.</p>
                </div>
            `;
            return;
        }

        container.innerHTML = jobs.map(job => {

            const companyName =
                job.company && job.company.companyName
                    ? job.company.companyName
                    : "Company";

            return `
                <div class="job-card">

                    <h3>${job.title || "Job Position"}</h3>

                    <div class="company">
                        ${companyName}
                    </div>

                    <div class="info">
                        Location: ${job.location || "Not specified"}
                    </div>

                    <div class="info">
                        Job Type: ${job.jobType || "Not specified"}
                    </div>

                    <div class="info">
                        Salary: ₹${job.salary || "Not specified"}
                    </div>

                    <div class="info">
                        Experience:
                        ${job.experienceRequired ?? 0} years
                    </div>

                    <div class="info">
                        Vacancies:
                        ${job.vacancies ?? 0}
                    </div>

                    <div class="skills">
                        <strong>Skills:</strong>
                        ${job.skillsRequired || "Not specified"}
                    </div>

                    <button
                        class="apply-btn"
                        onclick="applyForJob(${job.id})">
                        Apply Now
                    </button>

                </div>
            `;

        }).join("");

    } catch (error) {

        console.error("Job loading error:", error);

        container.innerHTML = `
            <div class="job-card">
                <h3>Unable to Load Jobs</h3>
                <p>${error.message}</p>
            </div>
        `;
    }
}


async function applyForJob(jobId) {

    const coverLetter =
        "I am interested in this position and would like to apply for the opportunity.";

    try {

        const url =
            `/api/applications?candidateId=${candidateId}` +
            `&jobId=${jobId}` +
            `&coverLetter=${encodeURIComponent(coverLetter)}`;

        const response = await fetch(url, {
            method: "POST"
        });

        if (!response.ok) {
            const message = await response.text();
            throw new Error(message);
        }

        alert("Application submitted successfully!");

        loadApplications();

    } catch (error) {

        console.error("Application error:", error);

        alert("Application failed: " + error.message);
    }
}


async function loadApplications() {

    const container =
        document.getElementById("applicationList");

    try {

        const response =
            await fetch(`/api/applications/candidate/${candidateId}`);

        if (!response.ok) {
            throw new Error(
                "Applications API returned " + response.status
            );
        }

        const applications = await response.json();

        if (!Array.isArray(applications) || applications.length === 0) {

            container.innerHTML = `
                <div class="application-card">
                    <h3>No Applications</h3>
                    <p>You have not applied for any jobs yet.</p>
                </div>
            `;

            return;
        }

        container.innerHTML = applications.map(application => {

            const job = application.job || {};

            const company =
                job.company && job.company.companyName
                    ? job.company.companyName
                    : "Company";

            return `
                <div class="application-card">

                    <h3>${job.title || "Job Application"}</h3>

                    <p>
                        <strong>Company:</strong>
                        ${company}
                    </p>

                    <p>
                        <strong>Applied Date:</strong>
                        ${application.appliedDate || "N/A"}
                    </p>

                    <span class="status">
                        ${application.status || "APPLIED"}
                    </span>

                </div>
            `;

        }).join("");

    } catch (error) {

        console.error("Application loading error:", error);

        container.innerHTML = `
            <div class="application-card">
                <h3>Applications</h3>
                <p>Unable to load applications.</p>
            </div>
        `;
    }
}


async function loadApplicants() {

    const container =
        document.getElementById("applicantList");

    try {

        const response =
            await fetch("/api/applications/job/1");

        if (!response.ok) {
            throw new Error(
                "Applicants API returned " + response.status
            );
        }

        const applications = await response.json();

        if (!Array.isArray(applications) || applications.length === 0) {

            container.innerHTML = `
                <div class="applicant-card">
                    <h3>No Applicants</h3>
                    <p>No candidates have applied for this job.</p>
                </div>
            `;

            return;
        }

        container.innerHTML = applications.map(application => {

            const candidate =
                application.candidate || {};

            return `
                <div class="applicant-card">

                    <h3>
                        ${candidate.firstName || ""}
                        ${candidate.lastName || ""}
                    </h3>

                    <p>
                        <strong>Email:</strong>
                        ${candidate.email || "N/A"}
                    </p>

                    <p>
                        <strong>Skills:</strong>
                        ${candidate.skills || "N/A"}
                    </p>

                    <p>
                        <strong>Qualification:</strong>
                        ${candidate.qualification || "N/A"}
                    </p>

                    <span class="status">
                        ${application.status || "APPLIED"}
                    </span>

                </div>
            `;

        }).join("");

    } catch (error) {

        console.error("Applicant loading error:", error);

        container.innerHTML = `
            <div class="applicant-card">
                <h3>Recruiter Dashboard</h3>
                <p>Unable to load applicants.</p>
            </div>
        `;
    }
}