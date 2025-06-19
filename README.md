Overview
This project is a low-level design implementation of a Ticket Booking System, inspired by platforms like BookMyShow. It tackles core design challenges, especially concurrency, to ensure critical issues like duplicate seat bookings are handled efficiently. The system was designed as part of a hands-on learning module focused on practical system design problems.

Key Concepts and Requirements
Concurrency Handling
Prevents multiple users from booking the same seat simultaneously.

Implements thread-safe logic during the seat selection and booking phase (similar to the IRCTC use case).

Functional Requirements
Multi-City Support: Each city can host multiple theaters.

Multi-Screen Theaters: Each theater can have multiple screens showing different movies simultaneously.

Seat Selection: Users can choose their exact seat(s), which is critical for a movie booking system.

Show Variants: Supports variations like 2D, 3D, IMAX, Dolby Atmos, etc.

Payments: Supports integration with payment gateways like Razorpay and Stripe, with multiple modes of transaction.

Class Diagram and Entity Overview
Entity	Description
City	Holds city-specific details (ID, Name).
Theatre	Contains metadata (ID, Name, City) and a list of screens.
Screen	Houses multiple seats with different types (Regular, Recliner, etc.).
Seat	Pricing varies based on SeatType and Show.
Show	Represents a movie played at a specific time on a screen.
Ticket	Captures booking info including seats, user, and payment status.
Payment	Contains transaction-related details and status.

Booking and Payment Flow
User searches for a movie and selects a city.

Picks a theater, show timing, and screen.

Chooses desired seats (which are temporarily locked).

Proceeds to payment via an integrated gateway.

On successful payment, a ticket is generated.

Database Schema and REST API Layer
Schema Design
Entities like User, Show, Seat, Ticket, Payment, etc., are modeled in the database.

The schema supports indexing and lookup for high-speed access and concurrency-safe operations.

REST APIs
The system exposes APIs for:

Searching shows and theaters

Fetching seat availability

Booking and confirming tickets

Payment processing

Additional Design Considerations
Seats are temporarily locked when a user selects them to avoid race conditions.

The system supports partial payments, booking cancellation, and payment retries.

While similar to IRCTC ticketing systems, this design guarantees seat selection, which is a key differentiator.

Summary
This project mirrors real-world scenarios from companies like BookMyShow and IRCTC, particularly around concurrency control, transactional safety, and providing a seamless user experience under high demand. It provides a production-ready skeleton for building a scalable and efficient ticket booking platform.

