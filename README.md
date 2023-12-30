# secureUs
Welcome to SecureUs, the epitome of secure living.

Our cutting-edge platform boasts a robust object detection algorithm meticulously crafted using OpenCV, PyTorch, Ultralytics, and the powerful YOLOv8 model. Presently, our image classification model adeptly identifies humans, and in the forthcoming iterations, users will have the capability to train the YOLOv8 model to distinguish between residents and potential intruders on a property. View the Intruder detection model here - https://github.com/Prathmesh234/secureUs-ml

To augment security measures, we are integrating Hugging Face's state-of-the-art Facebook/DPT-DiNoV2-Large-KITTI model. This feature enables the system to identify intruders within a specified vicinity, triggering immediate alerts to users through email or text messages.

At the core of our system is a seamless API service built on Spring Boot, facilitating the storage of all recorded videos in an AWS S3 bucket. This ensures accessibility for users to review footage at their convenience. To optimize S3 bucket costs, our application intelligently stores only specific segments of object detection videos.

While currently leveraging a dummy database for swift responses, we have strategic plans to migrate user information to AWS for enhanced scalability and efficiency.

(To be noted, this project will be released in iterations however phase 1 has been completed.)
Stack-
    Frontend - ReactJS, CSS, Material UI
    API Service - Springboot, Maven, Axios
    Backend - AWS S3, AWS IAM 
    ML Tools - Python, Pytorch, facebook/dpt-dinov2-large-kitti depth estimation model, OpenCV, YoloV8


